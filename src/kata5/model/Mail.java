package kata5.model;

public class Mail {
    private String mail;

    public Mail(String mail) {
        this.mail = mail;
    }
    
    public String getDomain() {
        return mail.substring(mail.indexOf('@'));
    }

    public String getMail() {
        return mail;
    }
    
}