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
    private PrepareCardHelper prepareCardHelper;
    @Autowired
    private TeamMemberRepository teamMemberRepository;

    public CardPersist prepareIssue(CardEntity issue){
        issue.setTitle("Issue-#"+SequenceTask.getInstance().getNextValue());
        issue.setLabels("Error");
        CardPersist cardPersist = new CardPersist(issue);

        var team = teamMemberRepository.findById(1);//default member team to issues
        if (team.isPresent()){
            AssignmentEntity assignment= new AssignmentEntity();
            assignment.setTeamMember(team.get());
            assignment.setCard(issue);

            cardPersist.setAssignment(assignment);
        }

        return cardPersist;
    }

    public CardPersist prepareBug(CardEntity bug){

      bug.setList("To-Do");
        return new CardPersist(bug);
    }

    public CardPersist prepareTask(CardEntity task)
    {
        return new CardPersist(task);
    }
}
