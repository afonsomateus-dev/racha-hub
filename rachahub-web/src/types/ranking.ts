import type { Player } from "./player";

export type RankTab = "wins" | "goals" | "apps" | "rate" | "streak";

export interface TabsProps {
  id: RankTab; 
  icon: string; 
  label: string
}

export interface RankingTabsProps {
  tabs: TabsProps[];
  currentTab: RankTab;
  onSelect: (tab: RankTab) => void;
}

export interface RankingTopPositionsProps {
  players: Player[];
  currentTab: RankTab;
}