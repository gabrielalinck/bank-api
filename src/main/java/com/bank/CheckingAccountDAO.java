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
        return jdbcTemplate.query("select * from checking_account", new CheckingAccountMapper());
    }

    class CheckingAccountMapper implements RowMapper<CheckingAccountEntity> {
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
