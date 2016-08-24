package ateam.logic;

import java.util.List;

import ateam.model.Bihin;
import ateam.dao.BihinDAO;

public class MyPageLogic {
	public static List<Bihin> getBihinList(String id) {
		ateam.dao.BihinDAO dao = ateam.dao.BihinDAO.getInstance();
		List <Bihin> list = dao.getBihinList(id);

		return list;
	}
}
