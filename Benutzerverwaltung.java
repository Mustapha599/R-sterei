import utils.BinarySearchTree;

public class Benutzerverwaltung extends BinarySearchTree {

    private BinarySearchTree<Benutzerprofil> benutzerBaum;


    public Benutzerverwaltung(){
        benutzerBaum= new BinarySearchTree<>();
    }

    public void neuenBenutzerAnlegen(String pBenutzername, String pPw){
    Benutzerprofil x;
    x=new Benutzerprofil(pBenutzername, pPw);
    }

    public void nutzerLoeschen(String pBenutzername, String pPw){
     this.remove(pBenutzername && pPw);
    }

    public void profilVoranden(String pBenutzername){
     this.search(pBenutzername);
    }



}