package com.demo.managment;

import com.demo.managment.model.CardEntity;
import com.demo.managment.model.TeamMemberEntity;
import com.demo.managment.repository.TeamMemberRepository;
import com.demo.managment.service.PrepareCardHelper;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class PrepareCardHelperTest {

   @MockBean
   private TeamMemberRepository teamMemberRepository;
    private PrepareCardHelper helper ;
    @BeforeEach
    void setUp(){
        teamMemberRepository = mock(TeamMemberRepository.class);
        helper = new PrepareCardHelper(teamMemberRepository);

    }

    @Test
    void prepareIssueEmptyList(){
        CardEntity test = new CardEntity();
        var result = helper.prepareIssue(test);
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getCard());
        Assertions.assertNotNull(result.getCard().getList());

        Assertions.assertEquals("To-Do",result.getCard().getList());
    }

    @Test
    void prepareBug(){
        //mock
        TeamMemberEntity member = TeamMemberEntity.builder()
                .id(1)
                .lastName("Snow")
                .name("Jhon")
                .personalId("123456")
                .build();

        when(teamMemberRepository.findById(1))
                .thenReturn(Optional.of(member));
        CardEntity test = new CardEntity();
        var result = helper.prepareBug(test);
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getCard());

        Assertions.assertNotNull(result.getCard().getTitle());
        Assertions.assertEquals("Bug-#-1",result.getCard().getTitle());

        Assertions.assertNotNull(result.getCard().getLabel());
        Assertions.assertEquals("Bug",result.getCard().getLabel());


        Assertions.assertNotNull(result.getAssignment());
    }


    @Test
    void prepareTask(){
        CardEntity test = new CardEntity();
        var result = helper.prepareTask(test);
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getCard());
        Assertions.assertNull(result.getAssignment());
        Assertions.assertNull(result.getCard().getList());
    }


}
