package lt.vu.usecases;

import lt.vu.services.CarModelUpdaterAsync;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class UpdateCarModel implements Serializable {

    private int carId;

    @Inject
    private CarModelUpdaterAsync updater;

    private CompletableFuture<String> update1Future = null;

    private CompletableFuture<String> update2Future = null;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        carId = Integer.parseInt(requestParameters.get("cId"));
    }

    public String test(){
        update1Future = CompletableFuture.supplyAsync(() -> updater.update(carId,"111", 0, 1000));
        update2Future = CompletableFuture.supplyAsync(() -> updater.update(carId,"222", 200, 100));
        return "accidents?cId=" + this.carId + "&faces-redirect=true";
    }

    public boolean isUpdate1Running() {
        return this.update1Future != null && !this.update1Future.isDone();
    }
    public boolean isUpdate2Running() {
        return this.update2Future != null && !this.update2Future.isDone();
    }

    public String getUpdate1Status() throws ExecutionException, InterruptedException {
        if (update1Future == null) {
            return null;
        } else if (isUpdate1Running()) {
            return "Update 1 in progress...";
        }
        return "Update1 Status: " + update1Future.get();
    }
    public String getUpdate2Status() throws ExecutionException, InterruptedException {
        if (update2Future == null) {
            return null;
        } else if (isUpdate2Running()) {
            return "Update 2 in progress...";
        }
        return "Update2 Status: " + update2Future.get();
    }
}
