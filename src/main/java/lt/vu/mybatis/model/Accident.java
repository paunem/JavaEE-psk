package lt.vu.mybatis.model;

import java.util.Date;

public class Accident {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ACCIDENT.ID
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ACCIDENT.DATE
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    private Date date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ACCIDENT.TIME
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    private Date time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ACCIDENT.CITY
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    private String city;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ACCIDENT.ID
     *
     * @return the value of PUBLIC.ACCIDENT.ID
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ACCIDENT.ID
     *
     * @param id the value for PUBLIC.ACCIDENT.ID
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ACCIDENT.DATE
     *
     * @return the value of PUBLIC.ACCIDENT.DATE
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ACCIDENT.DATE
     *
     * @param date the value for PUBLIC.ACCIDENT.DATE
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ACCIDENT.TIME
     *
     * @return the value of PUBLIC.ACCIDENT.TIME
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ACCIDENT.TIME
     *
     * @param time the value for PUBLIC.ACCIDENT.TIME
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ACCIDENT.CITY
     *
     * @return the value of PUBLIC.ACCIDENT.CITY
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ACCIDENT.CITY
     *
     * @param city the value for PUBLIC.ACCIDENT.CITY
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    public void setCity(String city) {
        this.city = city;
    }
}