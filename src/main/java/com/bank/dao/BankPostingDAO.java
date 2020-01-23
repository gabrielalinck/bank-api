package com.bank.dao;

import com.bank.entity.BankPostingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankPostingDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    static class BankPostingMapper implements RowMapper<BankPostingEntity> {
        @Override
        public BankPostingEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            BankPostingEntity bankPostingEntity = new BankPostingEntity();
            bankPostingEntity.setPostingId(rs.getInt("posting_id"));
            bankPostingEntity.setRecipientAccount(rs.getInt("recipient_account"));
            bankPostingEntity.setOriginAccount(rs.getInt("origin_account"));
            bankPostingEntity.setPostingDate(rs.getDate("posting_date").toLocalDate());
            bankPostingEntity.setTotalValue(rs.getInt("total_value"));

            return bankPostingEntity;
        }
    }
}
