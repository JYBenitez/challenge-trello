package com.demo.managment.service.integration.trello;

import com.demo.managment.model.CardEntity;
import com.demo.managment.service.integration.trello.message.CardMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class TrelloSender {

    @Value("${trello.label.bug}")
    private String labelBugId;

    @Value("${trello.label.maintenance}")
    private String labelMaintenanceId;

    @Value("${trello.label.test}")
    private String labelTestId;

    @Value("${trello.label.research}")
    private String labelReseachId;

    @Value("${trello.mamber.id}")
    private String memberId;

    @Value("${trello.list.unassignment}")
    private String listUnassignmentId;

    @Value("${trello.list.todo}")
    private String listTodoId;

    @Value("${trello.api.uri}")
    private String trelloUri;

    @Value("${trello.list.id}")
    private String listid;

    @Value("${trello.api.key}")
    private String key;

    @Value("${trello.token}")
    private String token;

    public void send(CardEntity info)  {
        var messageToSend = map(info);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json ="";
        try {
             json = ow.writeValueAsString(messageToSend);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }

        CloseableHttpClient httpClient = HttpClients.createDefault();
        String uri = String.format("https://api.trello.com/1/lists/%s/cards?key=%s&token=%s",getList(info.getType()),key,token);
        HttpPost post = new HttpPost(uri);
        //"https://api.trello.com/1/lists/61e4a67330742809dc463add/cards?key=1438c8b24fd26dcbfb57eb08e5ffcbff&token=17900bf7dde7725a8a520a0a8702c4ecc4298f26beeb6e55245f9f314236e4ec");

        StringEntity params = null;
        try {
            params = new StringEntity(json);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        post.addHeader("content-type", "application/json");
        post.setEntity(params);

        try {
            var response = httpClient.execute(post);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private CardMessage map(CardEntity card){
        CardMessage message = new CardMessage();
        BeanUtils.copyProperties(card,message,"id");
        if (StringUtils.hasLength(card.getLabel())) {
            List<String> labels = new ArrayList<>();
            labels.add(getLabel(card.getLabel()));
            message.setIdLabels(labels);
        }
        if (CardEntity.Type.BUG.equals(card.getType())){
            List<String> members = new ArrayList<>();
            members.add(memberId);
            message.setIdMembers(members);
        }
        message.setIdList(getList(card.getType()));
        return message;
    }

    private String getLabel(@NotNull final String label) {
        if(StringUtils.hasLength(label))
        {
            if ("BUG".equals(label.toUpperCase())){
                return labelBugId;
            }
            if ("MAINTENANCE".equals(label.toUpperCase())){
                return labelMaintenanceId;
            }
            if("RESEARCH".equals(label.toUpperCase())) {
                return labelReseachId;
            }
            if ("TEST".equals(label.toUpperCase())) {
                return labelTestId;
            }
        }
        return null;
    }

    private String getList(@NotNull final CardEntity.Type type){
        if (type.equals(CardEntity.Type.ISSUE)){
            return listTodoId;
        }
        else {
            return listUnassignmentId;
        }
    }

}
