package lt.vu.mybatis.model;

public class Car {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.CAR.ID
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.CAR.VIN
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    private String vin;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.CAR.MANUFACTURER
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    private String manufacturer;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.CAR.MODEL
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    private String model;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.CAR.OWNER_ID
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    private Integer ownerId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.CAR.ID
     *
     * @return the value of PUBLIC.CAR.ID
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.CAR.ID
     *
     * @param id the value for PUBLIC.CAR.ID
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.CAR.VIN
     *
     * @return the value of PUBLIC.CAR.VIN
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public String getVin() {
        return vin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.CAR.VIN
     *
     * @param vin the value for PUBLIC.CAR.VIN
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public void setVin(String vin) {
        this.vin = vin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.CAR.MANUFACTURER
     *
     * @return the value of PUBLIC.CAR.MANUFACTURER
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.CAR.MANUFACTURER
     *
     * @param manufacturer the value for PUBLIC.CAR.MANUFACTURER
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.CAR.MODEL
     *
     * @return the value of PUBLIC.CAR.MODEL
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public String getModel() {
        return model;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.CAR.MODEL
     *
     * @param model the value for PUBLIC.CAR.MODEL
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.CAR.OWNER_ID
     *
     * @return the value of PUBLIC.CAR.OWNER_ID
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public Integer getOwnerId() {
        return ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.CAR.OWNER_ID
     *
     * @param ownerId the value for PUBLIC.CAR.OWNER_ID
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}