package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Owner;

public interface OwnerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.OWNER
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.OWNER
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    int insert(Owner record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.OWNER
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    Owner selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.OWNER
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    List<Owner> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.OWNER
     *
     * @mbg.generated Sat Mar 27 19:17:58 EET 2021
     */
    int updateByPrimaryKey(Owner record);
}