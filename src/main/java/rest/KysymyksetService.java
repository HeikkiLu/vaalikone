package rest;

import java.util.List;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.appengine.api.datastore.ReadPolicy.Consistency;

import dao.KysymyksetDao;
import persist.Kysymykset;

@Path("/kysymyksetservice")
public class KysymyksetService {

	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Kysymykset> getAll() {
		return KysymyksetDao.getKysymykset();
	}

	@POST
	@Path("/addkysymys")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addKysymys(Kysymykset kys) {
		KysymyksetDao.addKysymys(kys);
	}
	
	@DELETE
	@Path("/deletekysymys")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteKysymys(Kysymykset kys) {
		 KysymyksetDao.deleteKysymys(kys);
	}
	
	@POST
	@Path("/modifykysymys")
	@Consumes(MediaType.APPLICATION_JSON)
	public void modifyKysymys(Kysymykset kys) {
		KysymyksetDao.modifyKysymys(kys);
	}
}
