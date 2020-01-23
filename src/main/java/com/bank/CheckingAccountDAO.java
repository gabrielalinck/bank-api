package com.bank;

import com.bank.entity.CheckingAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CheckingAccountDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CheckingAccountEntity> getAccounts() {
        String sql = "select * from checking_account";
        return jdbcTemplate.query(sql, new CheckingAccountMapper());
    }

    public CheckingAccountEntity getAccountById(int id){
        String sql = "select * from checking_account where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id }, new CheckingAccountMapper());
    }

    public CheckingAccountEntity getAccountBySocialNumber(String socialNumber){
        String sql = "select * from checking_account where social_number=?";
        return jdbcTemplate.queryForObject(sql, new Object[] { socialNumber }, new CheckingAccountMapper());
    }

    public Integer updateCheckingAccount(CheckingAccountEntity checkingAccountEntity){
        return jdbcTemplate.update("update checking_account " + " set first_name = ?, last_name = ?, social_number = ?, total_savings = ?" + " where id = ?",
                checkingAccountEntity.getFirstName(), checkingAccountEntity.getLastName(), checkingAccountEntity.getSocialNumber(), checkingAccountEntity.getTotalSavings(), checkingAccountEntity.getId());

    }

    static class CheckingAccountMapper implements RowMapper<CheckingAccountEntity> {
        @Override
        public CheckingAccountEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            CheckingAccountEntity checkingAccountEntity = new CheckingAccountEntity();
            checkingAccountEntity.setId(rs.getInt("id"));
            checkingAccountEntity.setFirstName(rs.getString("first_name"));
            checkingAccountEntity.setLastName(rs.getString("last_name"));
            checkingAccountEntity.setSocialNumber(rs.getString("social_number"));
            checkingAccountEntity.setTotalSavings(rs.getInt("total_savings"));

            return checkingAccountEntity;
        }
    }
}
