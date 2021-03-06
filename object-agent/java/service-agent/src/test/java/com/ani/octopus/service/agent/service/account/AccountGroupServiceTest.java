package com.ani.octopus.service.agent.service.account;

import com.ani.octopus.commons.accout.dto.AccountDto;
import com.ani.octopus.commons.accout.dto.AccountGroupDto;
import com.ani.octopus.commons.accout.dto.GroupFormDto;
import com.ani.octopus.commons.accout.dto.GroupType;
import com.ani.octopus.commons.core.message.OctopusMessage;
import com.ani.octopus.service.agent.core.config.AnicelMeta;
import com.ani.octopus.service.agent.core.http.RestTemplateFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhaoyu on 15-12-15.
 */
public class AccountGroupServiceTest {
    private ObjectMapper objectMapper;
    private AccountGroupService accountGroupService;
    private String accessToken = "1a014ee8-8122-44e7-83d3-640704fbe014";

    @Before
    public void before() {
        objectMapper = new ObjectMapper();

        AnicelMeta anicelMeta = new AnicelMeta();
        RestTemplateFactory templateFactory = new RestTemplateFactory();
        accountGroupService = new AccountGroupServiceImpl(
                anicelMeta,
                templateFactory,
                accessToken
        );
    }
    @Test
    public void testSave() throws Exception {
        Long accountId = 4655394565573078056L;
        GroupFormDto groupFormDto = new GroupFormDto(
                "ROLE_FRIEND",
                GroupType.CUSTOM,
                accountId
        );

        AccountGroupDto accountGroupDto = accountGroupService.save(groupFormDto);
        System.out.println(accountGroupDto);
    }

    @Test
    public void testModify() throws Exception {
        Long accountId = 4655394565573078056L;
        GroupFormDto groupFormDto = new GroupFormDto(
                3L,
                "ROLE_FRIEND",
                GroupType.CUSTOM,
                accountId
        );
        AccountGroupDto accountGroupDto = accountGroupService.modify(groupFormDto);
        System.out.println(accountGroupDto);
    }

    @Test
    public void testRemove() throws Exception {
        Long accountId = 4655394565573078056L;
        //Long accountId = 5171261575755046940L;
        Long groupId = 3L;

        OctopusMessage message = accountGroupService.remove(accountId, groupId);
        System.out.println(message);
    }

    @Test
    public void testGetById() throws Exception {
        Long groupId = 2L;
        AccountGroupDto accountGroupDto = accountGroupService.getById(groupId);
        System.out.println(accountGroupDto);
        Assert.assertNotNull(accountGroupDto);
    }

    @Test
    public void testGetByAccountAndGroupType() throws Exception {
        //Long accountId = 5171261575755046940L;
        Long accountId = 5391071553898021350L;
        Collection<AccountGroupDto> groupDtoList = accountGroupService
                .getByAccountAndGroupType(accountId, GroupType.SYSTEM);
        Assert.assertEquals(1, groupDtoList.size());
    }

    @Test
    public void testGetAccountsInGroup() throws Exception {
        Collection<AccountDto> accountDtoCollection = accountGroupService
                .getAccountsInGroup(2L);
        System.out.println(accountDtoCollection.size());
    }
}