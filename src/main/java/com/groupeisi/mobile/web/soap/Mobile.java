package com.groupeisi.mobile.web.soap;

import javax.jws.WebMethod;
import javax.xml.ws.Endpoint;
import com.groupeisi.mobile.web.soap.services.solde;
import com.groupeisi.mobile.web.soap.services.paiement;
import com.groupeisi.mobile.web.soap.services.client;
import com.groupeisi.mobile.web.soap.services.transaction;


public class Mobile {
    @WebMethod
    // Transfert
    public boolean transfer(String senderPhoneNumber, String receiverPhoneNumber, int amount) {
        // Valider les entrées
        if (senderPhoneNumber == null || senderPhoneNumber.isEmpty()) {
            return false;
        }
        if (receiverPhoneNumber == null || receiverPhoneNumber.isEmpty()) {
            return false;
        }
        if (amount <= 0) {
            return false;
        }

        // Vérifier si le client expéditeur existe et a suffisamment de fonds
        boolean senderExists = checkClientExists(senderPhoneNumber);
        if (!senderExists) {
            return false;
        }
        int senderBalance = checkClientBalance(senderPhoneNumber);
        if (senderBalance < amount) {
            return false;
        }

        // Vérifier si le client destinataire existe
        boolean receiverExists = checkClientExists(receiverPhoneNumber);
        if (!receiverExists) {
            return false;
        }

        // Effectuer le transfert
        boolean transferSuccess = performTransfer(senderPhoneNumber, receiverPhoneNumber, amount);
        if (!transferSuccess) {
            return false;
        }

        return true;
    }

    private boolean performTransfer(String senderPhoneNumber, String receiverPhoneNumber, int amount) {
        return false;
    }


    private int checkClientBalance(String senderPhoneNumber) {
        return 0;
    }

    private boolean checkClientExists(String receiverPhoneNumber) {
        return false;
    }

    // Paiement
    @WebMethod
    public boolean pay(String beneficiaryPhoneNumber, int amount) {
       // Valider les entrées
        if (beneficiaryPhoneNumber == null || beneficiaryPhoneNumber.isEmpty()) {
            return false;
        }
        if (amount <= 0) {
            return false;
        }
        // Vérifier si le bénéficiaire existe
        boolean beneficiaryExists = checkClientExists(beneficiaryPhoneNumber);
        if (!beneficiaryExists) {
            return false;
        }
        //Vérifier si le client a suffisamment de fonds
        int clientBalance = checkClientBalance(beneficiaryPhoneNumber);
        if (clientBalance < amount) {
            return false;
        }
        // Effectuer le paiement
        boolean paymentSuccess = performPayment(beneficiaryPhoneNumber, amount);
        if (!paymentSuccess) {
            return false;
        }
        return true;
    }

    private boolean performPayment(String beneficiaryPhoneNumber, int amount) {
        return false;
    }

    // Solde
    @WebMethod
    public int balance(String clientPhoneNumber) {
        // Valider les entrées
        if (clientPhoneNumber == null || clientPhoneNumber.isEmpty()) {
            return -1;
        }
        // Vérifier si le client existe
        boolean clientExists = checkClientExists(clientPhoneNumber);
        if (!clientExists) {
            return -1;
        }
        // Récupérer le solde du client
        int balance = checkClientBalance(clientPhoneNumber);
        return balance;
    }

    // Creation
    @WebMethod
    public boolean createClient(String clientPhoneNumber) {
        // Valider les entrées
        if (clientPhoneNumber == null || clientPhoneNumber.isEmpty()) {
            return false;
        }

        // Vérifier si le client existe déjà
        boolean clientExists = checkClientExists(clientPhoneNumber);
        if (clientExists) {
            return false;
        }

        // Créer le client
        boolean clientCreationSuccess = performClientCreation(clientPhoneNumber);
        if (!clientCreationSuccess) {
            return false;
        }

        return true;
    }

    private boolean performClientCreation(String clientPhoneNumber) {
        return false;
    }


    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/mobile_money", new Mobile());
    }
}
