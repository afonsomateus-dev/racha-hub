import { Calendar, ChevronRight, MapPin } from "lucide-react";
import type { HomeHeroProps } from "../../types/general";
import { fmtDate } from "../../utils/helpers";
import type { CSSProperties } from "react";

const D: CSSProperties = { fontFamily: "'Barlow Condensed', sans-serif" };

export const HomeHero = ({ match, winA, draw }: HomeHeroProps) => {
  return (
    <div
      className="rounded-2xl p-5 cursor-pointer active:scale-[0.99] transition-transform"
      style={{ background: "linear-gradient(150deg, #1c1c26 0%, #0e0e14 100%)", border: "1px solid rgba(255,255,255,0.08)" }}
      onClick={() => {}}
    >
      <div className="flex items-center justify-between mb-5">
        <div>
          <div className="text-[9px] tracking-[0.2em] text-white/30 uppercase">Último Racha</div>
          <div className="flex items-center gap-2 mt-0.5">
            <Calendar className="w-3 h-3 text-white/25" />
            <span className="text-xs text-white/35">{fmtDate(match.date)}</span>
            <span className="text-white/15">·</span>
            <MapPin className="w-3 h-3 text-white/25" />
            <span className="text-xs text-white/35">{match.location}</span>
          </div>
        </div>
        <ChevronRight className="w-4 h-4 text-white/20" />
      </div>
      <div className="flex items-center justify-center gap-8">
        <div className="flex-1 text-right">
          <div className="text-[10px] font-bold text-white/30 uppercase tracking-widest mb-1">Time A</div>
          <div style={{ ...D, fontSize: "5rem", fontWeight: 900, lineHeight: 1, color: winA ? "#00E87A" : draw ? "#f0f0f5" : "#FF3B30" }}>
            {match.teamA.score}
          </div>
        </div>
        <div className="text-2xl text-white/15 pb-3" style={D}>×</div>
        <div className="flex-1 text-left">
          <div className="text-[10px] font-bold text-white/30 uppercase tracking-widest mb-1">Time B</div>
          <div style={{ ...D, fontSize: "5rem", fontWeight: 900, lineHeight: 1, color: !winA && !draw ? "#00E87A" : draw ? "#f0f0f5" : "#FF3B30" }}>
            {match.teamB.score}
          </div>
        </div>
      </div>
      <div className="flex justify-center mt-4">
        <span className={`text-[10px] font-bold uppercase tracking-widest px-3 py-1 rounded-full ${draw ? "bg-white/8 text-white/40" : "bg-[#00E87A]/12 text-[#00E87A]"}`}>
          {draw ? "🤝 Empate" : winA ? "🏆 Vitória Time A" : "🏆 Vitória Time B"}
        </span>
      </div>
    </div>
  );
}