package com.M2I.gc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.M2I.gc.beans.Clients;
import com.M2I.gc.beans.Facture;
import com.M2I.gc.beans.FactureDet;
import com.M2I.gc.beans.Article;
public class LanceJPA {

	public static void main(String[] args) {
		EntityTransaction tx=null;//dans le cache je pr�vois si probl�me lance rollbback
		try {

	    	//Cr�ation de la Factory pour la persistence
	        EntityManagerFactory emf = EntityManagerHelper.getEntityManagerFactory();
	        //R�cup�ration � partir de la Factory d'un EntityManager
	        EntityManager em = emf.createEntityManager();

	        //S�lectionne le client dont l'id est 7
	        Clients client = (Clients) 
	        		em.find(Clients.class, 7);
	        //6 que CLIENT + Fact
	        //7 tout
	      
	       if(client != null)
	        {
	        	  //Si le client a �t� trouv� on affiche des informations
	        	System.out.println("Trouv� :) !");
		        System.out.println(String.format("Nom Client: %s, Adresse: %s", client.getNom(), client.getAdresse()));
		        for(Facture fact : client.getFactures())
		        {
		        	System.out.println(fact. getAdresse());
		        	for(FactureDet fd : fact.getFactDetails())
		        	{
		        		System.out.println("QTE : "+fd.getQuantity());
		        		System.out.println("PRIX : "+fd.getArticle().getTarifUnitaire()+" �");
		        		System.out.println("Montant HT : "+ 
		        		(fd.getArticle().getTarifUnitaire()*fd.getQuantity()+" �"));
		        	}
		        }
	        }
	        else
	        {
	        	//Si pas trouv� alors on cr�e un client 
	        	//c'est le SGBDR qui g�re les id !!
	        	System.out.println("Cr�ation");
	        	tx=em.getTransaction();
	        	//R�cup�ration d'une Transaction
	        	tx.begin();//D�but de la transaction
	        	
	        	//Instanciation d'une entit� client
	        	client = new Clients();
	        	//Affectation des donn�es du client
	        	client.setAdresse("rue de la vie");
	        	client.setCdp("13000");
	        	client.setNom("Client 1");
	        	client.setVille("Marseille");
	        	em.persist(client);//insert Client
	        	
	        	//bloc facture
	        	Facture fact = new Facture();
	        	fact.setClient(client);
	        	fact.setAdresse("idem");
	        	fact.setDescription("Facture M2I");
	        	fact.setMontant(125.36);
	        	fact.setPayer(false);
	        	em.persist(fact);//insert  Facture
	        	
	        	//Bloc Articles
	        	Article art = new Article();
	        	art.setDescription("Article 01");
	        	art.setTarifUnitaire(12.25);
	        	em.persist(art); //insert article
	        	
	        	//FactDet
	        	FactureDet fd = new FactureDet();
	        	fd.setArticle(art);
	        	fd.setFact(fact);
	        	fd.setQuantity(25);
	        	fd.setTxTva((float)0.2);
	        	em.persist(fd); //insert article
	        	//Close en m�me temps le transaction
	        	tx.commit();//Valide la transaction
	        	
	        }
	       
	       //Gestion Requ�tes
	        GestionRequetes gr = new GestionRequetes(em);
	        System.out.println("Factures Non Pay�es : "+gr.findAllFacturesPasPayees().size());
	        for(Facture fa : gr.findAllFacturesPasPayees())
	        {
	        	System.out.println(fa.getId()+"-"+fa.getClient().getNom());
	        }
	        System.out.println("Nombre des Clients : "+gr.findAllClients().size());
	        
	        for(Clients cl : gr.findAllClients())
	        {
	        	System.out.println(cl.getId()+"-"+cl.getNom());
	        }
	        
	        em.close();//ferme l'entit� manager

	    } catch (Exception e) {
	        e.printStackTrace();
	        if(tx!=null) tx.rollback();
	        //s'il y a eu une transaction on fait un roolback
	        //pour annuler toutes commandes orphelines
	    }


	}

}
