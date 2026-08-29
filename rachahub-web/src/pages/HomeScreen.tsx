import { MATCHES, PLAYERS } from "../constants";
import { HomeHero } from "../components/home/HomeHero";
import { Podium } from "../components/home/Podium";
import { Highlights } from "../components/home/Highlights";
import { RecentMatches } from "../components/home/RecentMatches";
export const HomeScreen = () => {
  const last = MATCHES[0];
  const byWins = [...PLAYERS].sort((a, b) => b.wins - a.wins);
  const winA = last.teamA.score > last.teamB.score;
  const draw = last.teamA.score === last.teamB.score;

  return (
    <div className="flex flex-col gap-6 pb-4">
      <div className="flex items-start justify-between pt-1">
        <div>
          <div className="text-[9px] tracking-[0.22em] text-white/25 uppercase mb-0.5">⚽ Temporada 2025</div>
          <h1 className="text-3xl font-black text-white tracking-tight leading-none font-title">AMIGOS DA AABB</h1>
        </div>
        <div className="flex flex-col items-end gap-1">
          <div className="flex items-center gap-1.5 bg-[#00E87A]/10 rounded-full px-2.5 py-1">
            <div className="w-1.5 h-1.5 rounded-full bg-[#00E87A] animate-pulse" />
            <span className="text-[10px] text-[#00E87A] font-bold tracking-wider">AO VIVO</span>
          </div>
          <span className="text-[10px] text-white/20">{MATCHES.length} partidas</span>
        </div>
      </div>

      <HomeHero 
        match={last}
        winA={winA}
        draw={draw}
      />

      <Podium playersByWin={byWins} />

      <Highlights players={PLAYERS} />

      <RecentMatches matches={MATCHES} />
    </div>

    
  );
}