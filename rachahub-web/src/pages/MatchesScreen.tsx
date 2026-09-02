import { MatchInfoCard } from "@components";
import { MATCHES } from "../constants";

export const MatchesScreen = () => {
    return (
      <div className="flex flex-col gap-4 pb-4">
        <div className="flex items-baseline justify-between pt-1">
          <h1 className="text-3xl font-black text-white font-title">PARTIDAS</h1>
          <span className="text-xs text-white/25">{MATCHES.length} jogos</span>
        </div>
        <MatchInfoCard matches={MATCHES} />
      </div>
    );
}