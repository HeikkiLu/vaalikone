package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.EhdokkaatDao;
import persist.Ehdokkaat;

@Path("/ehdokkaatservice")
public class EhdokkaatService {

	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ehdokkaat> getAll() {
		return EhdokkaatDao.getEhdokkaat();
    }
}