package wiss.modul295.modell;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "spiel")
public class Spiel {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int spiel_tore;



    public Spiel(int spiel_tore) {
        this.spiel_tore = spiel_tore;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpiel_tore() {
        return spiel_tore;
    }

    public void setSpiel_tore(int spiel_tore) {
        this.spiel_tore = spiel_tore;
    }
}
