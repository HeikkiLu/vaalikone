package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.VastauksetDao;
import persist.Vastaukset;

@Path("/vastauksetservice")
public class VastauksetService {
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vastaukset> getAll() {
		return VastauksetDao.getVastaukset();
	}
}
