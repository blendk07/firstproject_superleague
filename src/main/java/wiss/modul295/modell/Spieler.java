package wiss.modul295.modell;

import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "spieler")
public class Spieler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Vorname;
    private String name;
    private int spielernummer;
    private int spielertore;


    public Spieler() {
    }

    public Spieler(int id, String vorname, String name, int spielernummer, int spielertore) {
        this.id = id;
        Vorname = vorname;
        this.name = name;
        this.spielernummer = spielernummer;
        this.spielertore = spielertore;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpielernummer() {
        return spielernummer;
    }

    public void setSpielernummer(int spielernummer) {
        this.spielernummer = spielernummer;
    }

    public int getSpielertore() {
        return spielertore;
    }

    public void setSpielertore(int spielertore) {
        this.spielertore = spielertore;
    }
}

