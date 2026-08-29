export interface MatchTeam {
  name: string;
  score: number;
  players: number[];
  goals: number[];
}

export interface Match {
  id: number;
  date: string;
  location: string;
  participants: number;
  teamA: MatchTeam;
  teamB: MatchTeam;
}

export type Result = "W" | "L" | "D";

export interface MatchInfoCardProps {
  matches: Match[];
}