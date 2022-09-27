package wiss.modul295.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wiss.modul295.exceptions.TeamsException;
import wiss.modul295.modell.Teams;
import wiss.modul295.modell.TeamsRepository;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;



@RestController
    @RequestMapping(path = "/teams")
    public class  TeamsController {

    @Autowired
    private TeamsRepository teamsRepository;


    @PostMapping(path="/add") // Map ONLY POST Requests
    public String addNewTeam (@RequestParam String name,String trainer, float vermögen) {
        try {
            Teams c = new Teams();
            c.setTrainer(trainer);
            c.setVermögen(vermögen);
            c.setName(name);
            teamsRepository.save(c);
            return "Saved";
        } catch (Exception e) {
            return "There is something wrong";
        }
    }

    @GetMapping(path="/")
    public ResponseEntity<Iterable<Teams>> getAllSpiel() throws TeamsException {
            Iterable<Teams> team = null;

            try{
                team = teamsRepository.findAll();
            } catch (Exception e) {
                throw new TeamsException();
            }
            return ResponseEntity.ok(team);
        }


    @PutMapping(path = "/update")
    public String updateSpieler (@QueryParam("id") int id,
                                 @FormParam("trainer")String trainer,
                                 @FormParam("vermögen")float vermögen,
                                 @FormParam("name")String name){

        try {
            Teams teams = teamsRepository.findById(id).get();
            teams.setName(name);
            teams.setVermögen(vermögen);
            teams.setTrainer(trainer);
            teamsRepository.save(teams);
            return "Updated";
        } catch (Exception e){
            return "Something went wrong";
        }


    }

    @DeleteMapping(path = "/delete")
    public String deleteOldteams (@RequestParam int id) {

        try {
            teamsRepository.deleteById(id);
            return "Deleted";
        } catch (Exception e){
            return "Something went wrong";
        }
    }

}
