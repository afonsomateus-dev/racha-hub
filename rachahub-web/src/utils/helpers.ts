import { PLAYERS } from "../constants";
import type { Match } from "../types/match";
import type { Player } from "../types/player";

export const getPlayer = (id: number) => PLAYERS.find(p => p.id === id)!;
export const winRate = (p: Player) => Math.round((p.wins / p.apps) * 100);
export const initials = (s: string) => s.slice(0, 2).toUpperCase();
export const fmtDate = (s: string) => {
  const d = new Date(s + "T12:00:00");
  return d.toLocaleDateString("pt-BR", { day: "2-digit", month: "short" }).replace(".", "");
};
export const goalsBy = (match: Match, pid: number) =>
  [...match.teamA.goals, ...match.teamB.goals].filter(g => g === pid).length;

