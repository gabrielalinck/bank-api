package com.bank.dao;

import com.bank.entity.BankPostingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BankPostingDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<BankPostingEntity> getAllBankPosting() {
        String sql = "select * from bank_posting";
        return jdbcTemplate.query(sql, new BankPostingDAO.BankPostingMapper());
    }

    public BankPostingEntity getBankPostingById(int id) {
        String sql = "select * from bank_posting where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BankPostingDAO.BankPostingMapper());
    }

    public BankPostingEntity getBankPostingByOriginAccount(Integer originAccount) {
        String sql = "select * from bank_posting where origin_account=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{originAccount}, new BankPostingDAO.BankPostingMapper());
    }

    public BankPostingEntity getBankPostingByRecipientAccount(Integer recipientAccount) {
        String sql = "select * from bank_posting where recipient_account=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{recipientAccount}, new BankPostingDAO.BankPostingMapper());
    }

    public Integer updateBankPosting(BankPostingEntity bankPostingEntity) {
        return jdbcTemplate.update("update bank_posting " + " set posting_date = ?, origin_account = ?, recipient_account = ?, total_value = ?" + " where id = ?",
                bankPostingEntity.getPostingDate(), bankPostingEntity.getOriginAccount(), bankPostingEntity.getRecipientAccount(), bankPostingEntity.getTotalValue(), bankPostingEntity.getPostingId());

    }

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
