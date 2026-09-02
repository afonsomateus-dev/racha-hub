import type { Match } from "../types/match";
import type { Player } from "../types/player";

export const MATCHES: Match[] = [
  {
    id: 1, date: "2025-07-06", location: "AABB", participants: 10,
    teamA: { name: "T1", score: 5, players: [1,2,3,4,5], goals: [1,1,1,5,5] },
    teamB: { name: "T2", score: 3, players: [6,7,8,9,10], goals: [9,10,9] },
  },
  {
    id: 2, date: "2025-06-29", location: "AABB", participants: 10,
    teamA: { name: "T3", score: 2, players: [1,3,5,7,9], goals: [1,5] },
    teamB: { name: "T4", score: 4, players: [2,4,6,8,10], goals: [2,4,4,2] },
  },
  {
    id: 3, date: "2025-06-22", location: "AABB", participants: 10,
    teamA: { name: "T1", score: 3, players: [2,3,4,5,6], goals: [5,2,4] },
    teamB: { name: "T2", score: 3, players: [1,7,8,9,10], goals: [1,9,1] },
  },
  {
    id: 4, date: "2025-06-15", location: "AABB", participants: 10,
    teamA: { name: "T3", score: 6, players: [1,2,4,6,8], goals: [1,1,2,4,1,2] },
    teamB: { name: "T4", score: 2, players: [3,5,7,9,10], goals: [5,9] },
  },
  {
    id: 5, date: "2025-06-08", location: "AABB", participants: 10,
    teamA: { name: "T1", score: 1, players: [1,3,5,7,9], goals: [1] },
    teamB: { name: "T2", score: 3, players: [2,4,6,8,10], goals: [4,2,10] },
  },
  {
    id: 6, date: "2025-06-01", location: "AABB", participants: 10,
    teamA: { name: "T3", score: 4, players: [2,3,5,6,8], goals: [5,3,5,2] },
    teamB: { name: "T2", score: 1, players: [1,4,7,9,10], goals: [9] },
  },
  {
    id: 7, date: "2025-05-25", location: "AABB", participants: 10,
    teamA: { name: "T2", score: 2, players: [1,2,3,4,5], goals: [1,2] },
    teamB: { name: "T1", score: 2, players: [6,7,8,9,10], goals: [9,7] },
  },
  {
    id: 8, date: "2025-05-18", location: "AABB", participants: 10,
    teamA: { name: "T4", score: 7, players: [1,3,4,6,8], goals: [1,1,4,1,3,4,8] },
    teamB: { name: "T1", score: 2, players: [2,5,7,9,10], goals: [5,9] },
  },
];

export const PLAYERS: Player[] = [
  { id: 1, name: "Rodrigo", nick: "Rodriguinho", pos: "ATA", goals: 23, wins: 14, losses: 5, draws: 3, apps: 22, streak: 3, color: "#00E87A", lastResults: ["W","W","W","L","W"] },
  { id: 2, name: "Felipe", nick: "Filé", pos: "MEI", goals: 12, wins: 17, losses: 3, draws: 2, apps: 22, streak: 5, color: "#FFB800", lastResults: ["W","W","W","W","W"] },
  { id: 3, name: "Thiago", nick: "Tigrão", pos: "ZAG", goals: 8, wins: 13, losses: 6, draws: 3, apps: 22, streak: 1, color: "#3B82F6", lastResults: ["W","L","W","W","D"] },
  { id: 4, name: "Bruno", nick: "Brunão", pos: "MEI", goals: 11, wins: 12, losses: 7, draws: 2, apps: 21, streak: 2, color: "#A855F7", lastResults: ["W","W","D","L","W"] },
  { id: 5, name: "Lucas", nick: "Luquinhas", pos: "ATA", goals: 18, wins: 11, losses: 7, draws: 2, apps: 20, streak: 0, color: "#F97316", lastResults: ["L","W","W","L","W"] },
  { id: 6, name: "André", nick: "Dedé", pos: "GOL", goals: 3, wins: 10, losses: 7, draws: 3, apps: 20, streak: 1, color: "#06B6D4", lastResults: ["W","L","W","D","W"] },
  { id: 7, name: "Marcos", nick: "Marquinho", pos: "LAT", goals: 5, wins: 9, losses: 8, draws: 3, apps: 20, streak: 0, color: "#EF4444", lastResults: ["L","L","W","W","D"] },
  { id: 8, name: "Pedro", nick: "Pedrão", pos: "VOL", goals: 7, wins: 8, losses: 9, draws: 2, apps: 19, streak: 1, color: "#84CC16", lastResults: ["W","L","L","W","L"] },
  { id: 9, name: "Caio", nick: "Caiozinho", pos: "ATA", goals: 14, wins: 7, losses: 8, draws: 3, apps: 18, streak: 0, color: "#F59E0B", lastResults: ["L","W","L","W","L"] },
  { id: 10, name: "Rafael", nick: "Rafa", pos: "MEI", goals: 6, wins: 6, losses: 9, draws: 2, apps: 17, streak: 0, color: "#EC4899", lastResults: ["L","W","L","L","W"] },
];