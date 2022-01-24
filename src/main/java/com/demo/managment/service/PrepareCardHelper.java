package com.demo.managment.service;

import com.demo.managment.model.AssignmentEntity;
import com.demo.managment.model.CardEntity;
import com.demo.managment.repository.TeamMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public final class PrepareCardHelper {
    @Autowired
    private TeamMemberRepository teamMemberRepository;

    public CardPersist prepareIssue(CardEntity issue){

        issue.setList("To-Do");
        CardPersist cardPersist = new CardPersist(issue);

        return new CardPersist(issue);
    }

    public CardPersist prepareBug(CardEntity bug){

        bug.setTitle("Bug-#-"+SequenceTask.getInstance().getNextValue());
        bug.setLabel("Bug");
        CardPersist cardPersist = new CardPersist(bug);

        var team = teamMemberRepository.findById(1);//default member team to issues
        if (team.isPresent()){
            AssignmentEntity assignment= new AssignmentEntity();
            assignment.setTeamMember(team.get());
            assignment.setCard(bug);

            cardPersist.setAssignment(assignment);
        }
        return new CardPersist(bug);
    }

    public CardPersist prepareTask(CardEntity task)
    {
        return new CardPersist(task);
    }
}
