package core.faction.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import core.faction.Faction;
import core.util.ChatUtilities;

public class FactionCommands implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("faction")){
			if(args.length>0){
				if(args[0].equalsIgnoreCase("create")){
					if(args.length==2){
						Faction.createFaction(args[1], (Player) sender);
					}
					return true;
				}else
					if(args[0].equalsIgnoreCase("demote")){
						if(args.length==3){
							Player p = (Player) sender;
							Player owner = Faction.getOwner(args[1]);
							if(p.equals(owner)){
								for(Player player : Faction.getAdmins(args[1])){
									if(player.getName().equalsIgnoreCase(args[2])){
										Faction.demotePlayer(args[1], player);
									}
								}
							}
						}
						return true;
					}else
						if(args[0].equalsIgnoreCase("disband")){
							if(args.length==2){
								Player p = Faction.getOwner(args[1]);
								if(p.equals((Player)sender)||sender.isOp()){
									Faction.removeFaction(args[1]);
								}
							}
							return true;
						}else
							if(args[0].equalsIgnoreCase("home")){
								if(args.length==1){
									Player p = (Player) sender;
									String s = Faction.getFaction(p);
									if(s!=null){
									Faction.tpToSpawn(s, p);
									}
								}
								return true;
							}else
								if(args[0].equalsIgnoreCase("invite")){
									if(args.length==3){
										Player p2 = Faction.getOwner(args[1]);
										if(p2.equals((Player)sender)||sender.isOp()){
											for(Player p : Bukkit.getOnlinePlayers()){
												if(p.getName()==args[2]){
													Faction.invite(args[1], p);
													return false;
												}
											}
										}
									}
									return true;
								}else
									if(args[0].equalsIgnoreCase("join")){
										if(args.length==2){
											if(Faction.isPrivate(args[1])==true){
												Player p = (Player) sender;
												if(Faction.getInvites(args[1]).contains(p)){
													Faction.addPlayer(args[1], p);
												}
											}
											if(Faction.isPrivate(args[1])==false){
												Player p = (Player) sender;
												Faction.addPlayer(args[1], p);
											}
										}
										return true;
									}else
										if(args[0].equalsIgnoreCase("kick")){
											if(args.length==3){
												Player p = (Player) sender;
												List<Player> admins = Faction.getAdmins(args[1]);
												for(Player player : admins){
													if(player.equals(p)){
														for(Player player2 : Faction.getPlayers(args[1])){
															if(player2.getName().equalsIgnoreCase(args[2])){
																Faction.removePlayer(args[1], player2);;
															}
														}
													}
												}
											}
											return true;
										}else
											if(args[0].equalsIgnoreCase("promote")){
												if(args.length==3){
													Player p = (Player) sender;
													Player owner = Faction.getOwner(args[1]);
													if(p.equals(owner)){
														for(Player player : Faction.getPlayers(args[1])){
															if(player.getName().equalsIgnoreCase(args[2])){
																Faction.promotePlayer(args[1], player);
															}
														}
													}
												}
												return true;
											}else
												if(args[0].equalsIgnoreCase("setowner")){
													if(args.length==3){
														Player p = (Player) sender;
														Player owner = Faction.getOwner(args[1]);
														if(p.equals(owner)){
															for(Player player : Faction.getPlayers(args[1])){
																if(player.getName().equalsIgnoreCase(args[2])){
																	Faction.giveOwnership(args[1], player);
																}
															}
														}
													}
													return true;
												}else
													if(args[0].equalsIgnoreCase("setprivate")){
														if(args.length==2){
															Player p = Faction.getOwner(args[1]);
															if(p.equals((Player)sender)||sender.isOp()){
																if(Faction.isPrivate(args[1])==true){
																	Faction.setVisibility(args[1], false);
																}else
																	if(Faction.isPrivate(args[1])==false){
																		Faction.setVisibility(args[1], true);
																	}
															}
														}
														return true;
													}else
														if(args[0].equalsIgnoreCase("setspawn")){
															if(args.length==2){
																Player p = (Player) sender;
																Player owner = Faction.getOwner(args[1]);
																if(p.equals(owner)){
																	Faction.setSpawn(args[1], p.getLocation());
																}
															}
															return true;
														}else
															if(args[0].equalsIgnoreCase("help")){
																Player p = (Player) sender;
																p.sendMessage(ChatColor.GOLD + "Factions Help Menu");
																p.sendMessage(ChatColor.GREEN + "Commands");
																p.sendMessage(ChatColor.BLUE + "create");
																p.sendMessage(ChatColor.BLUE + "disband");
																p.sendMessage(ChatColor.BLUE + "invite");
																p.sendMessage(ChatColor.BLUE + "join");
																p.sendMessage(ChatColor.BLUE + "kick");
																p.sendMessage(ChatColor.BLUE + "promote");
																p.sendMessage(ChatColor.BLUE + "demote");
																p.sendMessage(ChatColor.BLUE + "setowner");
																p.sendMessage(ChatColor.BLUE + "setspawn");
																p.sendMessage(ChatColor.BLUE + "home");
																p.sendMessage(ChatColor.BLUE + "setprivate");
																return true;
															}else
																if(args[0].equalsIgnoreCase("list")){
																	if(args.length==2){
																		List<Player> players = Faction.inFaction(args[1]);
																		for(Player p: players){
																			sender.sendMessage(p.getName());
																		}
																	}
																	return true;
																}
			}
			Player p = (Player) sender;
			p.sendMessage("Please Provide An Argument!");
		}
		return true;
	}

}
