package com.bear.web;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bear.entity.UamGroup;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/group", produces = {"application/json;charset=utf-8"})
@Api(value = "/group", description="add a new group")
public class TestController {
    @RequestMapping(value = "addGroup", method = RequestMethod.POST)
    @ApiOperation(notes = "addGroup", httpMethod = "POST", value = "添加一个新的群组")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "invalid input")})
    @ResponseBody
    public UamGroup addGroup(@ApiParam(required = true, value = "group data") @RequestBody UamGroup group) {
        return group;
    }

    @RequestMapping(value = "getAccessibleGroups", method = RequestMethod.GET)
    @ApiOperation(notes = "getAccessibleGroups", httpMethod = "GET", value = "获取我可访问的群组列表 ")
    @ResponseBody
    public List<UamGroup> getAccessibleGroups() {
        UamGroup group1 = new UamGroup();
        group1.setGroupId("1");
        group1.setName("testGroup1");

        UamGroup group2 = new UamGroup();
        group2.setGroupId("2");
        group2.setName("testGroup2");

        List<UamGroup> groupList = new LinkedList<UamGroup>();
        groupList.add(group1);
        groupList.add(group2);

        return groupList;
    }
}
