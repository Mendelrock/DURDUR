clear

function x=hasard(p)
    N=lenght(p);
    z=rand();
    x=1;
    q(1)=p(1);
    for i=1:N-1
        if z>q(i) then
            x=x+1;
        end
        q(i+1)=q(i)+p(i+1);
    end
endfunction

function [P]=PR(K,a)
    //===== GENERATION DU RESEAU DE PAGES =====
    
    //matrice K*K avec une diagonale à 1 
    LIEN=diag(ones(1,K));
    //remplissage de toutes les cases avec 0 ou 1
    for i=1:K
        for j=1:K
            //On ne touche pas à la diagonale
            if i<>j then
                LIEN(i,j)=round(rand());
            end
        end
    end
    //Une page vers laquelle pointent toutes les pages: une colonne remplie de 1
    //Ici, la colonne round(K/2)
    for i=1:K
        LIEN(i,round(K/2))=1;
    end
    //Calcul du nombre de liens par pages
    NBRE=zeros(1,K);
    for i=1:K
        for j=1:K
            if LIEN(i,j)==1 then
                NBRE(i)=NBRE(i)+1;
            end
        end
    end
    //Calcul de la matrice de transition P du modèle
    P=zeros(K,K);
    for i=1:K
        for j=1:K
            P(i,j)=(1-a)/K;
            if i=j then
                P(i,j)=P(i,j)+(a/NBRE(i));
            end
        end
    end
    disp(LIEN);
    disp(NBRE);
    disp(P);
    
    //========= CALCUL DU PAGE RANK =========
    
    
    
    //=== SIMULATION DU RANDOM WEB SURFER ===
    
    
    
endfunction

[LOL]=PR(7,0.2)
