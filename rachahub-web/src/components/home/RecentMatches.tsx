import { ChevronRight } from "lucide-react";
import { fmtDate } from "../../utils/helpers";
import type { RecentMatchesProps } from "../../types/general";
import type { CSSProperties } from "react";

const D: CSSProperties = { fontFamily: "'Barlow Condensed', sans-serif" };

export const RecentMatches = ({ matches }: RecentMatchesProps) => {
  return (
    <div>
      <div className="flex items-center justify-between mb-3">
        <h2 className="text-[10px] font-bold text-white/40 uppercase tracking-[0.18em]">Últimas Partidas</h2>
      </div>
      <div className="flex flex-col gap-2">
        {matches.slice(0, 4).map(m => {
          const wa = m.teamA.score > m.teamB.score;
          const dr = m.teamA.score === m.teamB.score;
          return (
            <div
              key={m.id}
              className="flex items-center gap-3 p-3 rounded-xl cursor-pointer active:scale-[0.98] transition-transform"
              style={{ background: "#141419", border: "1px solid rgba(255,255,255,0.05)" }}
              onClick={() => {}}
            >
              <div className={`w-1 h-8 rounded-full shrink-0 ${wa ? "bg-[#00E87A]" : dr ? "bg-white/20" : "bg-[#FF3B30]"}`} />
              <div className="flex-1">
                <div className="text-xs font-semibold text-white/60">{fmtDate(m.date)}</div>
                <div className="text-[10px] text-white/25">{m.location}</div>
              </div>
              <div className="flex items-center gap-2">
                <span className="text-xl font-black text-white" style={D}>{m.teamA.score}</span>
                <span className="text-xs text-white/20">×</span>
                <span className="text-xl font-black text-white" style={D}>{m.teamB.score}</span>
              </div>
              <ChevronRight className="w-3.5 h-3.5 text-white/15" />
            </div>
          );
        })}
      </div>
    </div>
  );
}