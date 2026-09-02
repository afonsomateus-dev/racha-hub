import type { Result } from "./match";

export interface Player {
  id: number;
  name: string;
  nick: string;
  pos: string;
  goals: number;
  wins: number;
  losses: number;
  draws: number;
  apps: number;
  streak: number;
  color: string;
  lastResults: Result[];
}

export interface PlayerProfileScreenProps {
  player: Player;
}

export interface PlayerCardProps {
  player: Player;
}

export interface PlayerStatsGridProps {
  player: Player
}

export interface PlayerWinRateBarProps {
  player: Player;
}

export interface PlayerGoalsChartProps {
  player: Player;
}