package com.demo.managment;

import com.demo.managment.model.CardEntity;
import com.demo.managment.model.TeamEntity;
import com.demo.managment.model.TeamMemberEntity;
import com.demo.managment.repository.CardRepository;
import com.demo.managment.repository.TeamMemberRepository;
import com.demo.managment.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoadDataBase {
    private static final Boolean preloadTeam = false;
    private static final Boolean preloadTeamMember = false;
    private static final Boolean preloadCard = false;

    @Bean
    public CommandLineRunner initTeam(TeamRepository repository){

        TeamEntity mercurialSquad = new TeamEntity();
        mercurialSquad.setDescription("Mercurial Squad");

        TeamEntity jupiterSquad = new TeamEntity();
        jupiterSquad.setDescription("JupiterSquad");

        return args -> {
            if (Boolean.TRUE.equals(preloadTeam)){
            log.info("Preloading " + repository.save(mercurialSquad));
            log.info("Preloading " + repository.save(jupiterSquad));
            }
        };
    }

    @Bean
    public CommandLineRunner initTeamMember(TeamMemberRepository repository){
        TeamEntity team1 = new TeamEntity();
        team1.setId(1);

        TeamMemberEntity member1 = new TeamMemberEntity();
        member1.setLastName("Garcia");
        member1.setName("MArisa");
        member1.setPersonalId("332323");
        member1.setTeam(team1);


        return args -> {
            if (Boolean.TRUE.equals(preloadTeamMember)){
                log.info("Preloading " + repository.save(member1));
            }
        };
    }

    @Bean
    public CommandLineRunner initCard(CardRepository repository){
        CardEntity card1 = new CardEntity();
        card1.setDescription("Test creation");
        card1.setTitle("Test title");
        card1.setType(CardEntity.Type.TASK);

        return args -> {
            if (Boolean.TRUE.equals(preloadCard)){
                    log.info("Preloading " + repository.save(card1));
            }
        };
    }
}
