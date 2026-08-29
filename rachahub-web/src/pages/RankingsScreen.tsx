import { useState } from "react";
import { PLAYERS } from "../constants";
import type { RankTab, TabsProps } from "../types/ranking";
import { RankingTabs } from "../components/ranking/RankingTabs";
import { RankingTopPositions } from "../components/ranking/RankingTopPositions";

export const RankingsScreen = () => {
  const [tab, setTab] = useState<RankTab>("wins");

  const tabs: TabsProps[] = [
    { id: "wins", icon: "🏆", label: "Vitórias" },
    { id: "goals", icon: "⚽", label: "Artilharia" },
    { id: "apps", icon: "👥", label: "Presenças" },
    { id: "rate", icon: "📈", label: "Aproveito." },
    { id: "streak", icon: "🔥", label: "Sequência" },
  ];

  return (
    <div className="flex flex-col gap-5 pb-4">
      <h1 className="text-3xl font-black text-white pt-1 font-title">RANKINGS</h1>

      <RankingTabs 
        tabs={tabs}
        currentTab={tab}
        onSelect={setTab}
      />

      <RankingTopPositions 
        players={PLAYERS}
        currentTab={tab}
      />      
    </div>
  );
}