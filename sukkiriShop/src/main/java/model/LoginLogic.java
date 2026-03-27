package model;

import dao.AccountsDAO;
import util.HashUtil;

public class LoginLogic {
	public Account execute(Login login) {
		AccountsDAO dao = new AccountsDAO();
		Account account = dao.findByUserId(login.getUserId());

		if (account != null &&
			HashUtil.check(login.getPass(), account.getPass())) {
			return account;
		}
		return null;
	}
}