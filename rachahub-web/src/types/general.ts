import type { Match } from "./match";
import type { Player } from "./player";

export interface HomeHeroProps {
  match: Match;
  winA: boolean;
  draw: boolean;
}

export interface PodiumProps {
  playersByWin: Player[];
}

export interface HighlightsProps {
  players: Player[];
}

export interface RecentMatchesProps {
  matches: Match[];
}
