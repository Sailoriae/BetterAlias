package com.ne0nx3r0.betteralias.alias;

import java.util.HashMap;
import java.util.List;

public class Alias
{
    private final String command;
    private final String permission;
    private final HashMap<Integer, List<AliasCommand>> parameters;
     
    public Alias(String commandName)
    {
        this.command = commandName;
        this.permission = null;
        
        this.parameters = new HashMap<Integer,List<AliasCommand>>();
    }
      
    public Alias(String commandName,String permissionNode)
    {
        this.command = commandName;
        this.permission = permissionNode;
        
        this.parameters = new HashMap<Integer,List<AliasCommand>>();
    }

    public boolean hasCommandFor(int length)
    {
        return this.parameters.containsKey(length) || this.parameters.containsKey(-1);
    }

    public String getPermissionNode()
    {
        return this.permission;
    }

    public boolean hasPermission()
    {
        return this.permission != null;
    }

    Iterable<AliasCommand> getCommands(int length)
    {
        List<AliasCommand> commands = this.parameters.get(length);
        
        if(commands != null)
        {
            return commands;
        }

        return this.parameters.get(-1);
    }

    void setCommandsFor(int length,List<AliasCommand> commandsList)
    {
        this.parameters.put(length, commandsList);
    }
}
