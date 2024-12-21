package examen;


import examen.view.MainView.ClientView;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        FactoryRepository factoryRepository = new FactoryRepository();
        FactoryView factoryView = new FactoryView();
        FactoryService factoryService = new FactoryService(factoryRepository);
        ConnectionService connectionService = factoryService.getInstanceConnectionService();
        ConnectView connect = factoryView.getInstanceConnectView();

        System.out.println("=============== Bienvenue ===============");
        
        User userConnected = null;

        while (userConnected == null) {
            System.out.println("Veuillez vous connecter");
            User user = connect.saisie();
            userConnected = connectionService.getUser(user.getLogin(), user.getPassword());
            
            if (userConnected == null || userConnected.getRole() == null) {
                System.out.println("Erreur de connexion. Veuillez réessayer.");
            }
        }

        switch (userConnected.getRole()) {
           
            case CLIENT -> {
                ClienteleView clienteleView = new ClienteleView(userConnected);
                System.out.println("=============== Bonjour " + userConnected.getPrenom() + " " + userConnected.getNom() + " ===============");
                clienteleView.clientele();
            }
            default -> System.out.println("Erreur de connexion");
        }
    }
}
