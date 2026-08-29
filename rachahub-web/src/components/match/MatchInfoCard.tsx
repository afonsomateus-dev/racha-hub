import type { MatchInfoCardProps } from "../../types/match";
import { Calendar, ChevronRight, MapPin, Users } from "lucide-react";
import { fmtDate, getPlayer, initials } from "../../utils/helpers";


export const MatchInfoCard = ({ matches }: MatchInfoCardProps) => {
  return (
    <div className="flex flex-col gap-3">
      {
        matches.map(m => {
          const wa = m.teamA.score > m.teamB.score;
          const dr = m.teamA.score === m.teamB.score;
          const winner = m.teamA.score > m.teamB.score ? m.teamA : m.teamB

          return (
            <div
              key={m.id}
              className="rounded-2xl p-4 cursor-pointer active:scale-[0.98] transition-transform"
              style={{ background: "#141419", border: "1px solid rgba(255,255,255,0.06)" }}
              onClick={() => {}}
            >
              <div className="flex items-center gap-3 mb-4 text-white/30">
                <div className="flex items-center gap-1">
                  <Calendar className="w-3 h-3" /><span className="text-[11px]">{fmtDate(m.date)}</span>
                </div>
                <div className="w-1 h-1 rounded-full bg-white/15" />
                <div className="flex items-center gap-1">
                  <MapPin className="w-3 h-3" /><span className="text-[11px]">{m.location}</span>
                </div>
                <div className="w-1 h-1 rounded-full bg-white/15" />
                <div className="flex items-center gap-1">
                  <Users className="w-3 h-3" /><span className="text-[11px]">{m.participants}</span>
                </div>
              </div>
              <div className="flex items-center justify-between">
                <div className="flex-1">
                  <div className="text-[9px] text-white/25 uppercase tracking-widest mb-1.5">{m.teamA.name}</div>
                  <div className="flex -space-x-1.5">
                    {m.teamA.players.slice(0, 5).map(pid => {
                      const p = getPlayer(pid);
                      return (
                        <div 
                          key={pid} 
                          className="w-6 h-6 rounded-full flex items-center justify-center text-[8px] font-black border border-background font-title" 
                          style={{ background: p.color + "33", color: p.color }}
                        >
                          {initials(p.nick)}
                        </div>
                      );
                    })}
                  </div>
                </div>
                <div className="flex items-center gap-3 px-4">
                  <span className="text-5xl font-black leading-none font-title" style={{ color: wa ? "#00E87A" : dr ? "#f0f0f5" : "#FF3B30" }}>{m.teamA.score}</span>
                  <span className="text-white/20 text-2xl font-title">×</span>
                  <span className="text-5xl font-black leading-none font-title" style={{ color: !wa && !dr ? "#00E87A" : dr ? "#f0f0f5" : "#FF3B30" }}>{m.teamB.score}</span>
                </div>
                <div className="flex-1 flex justify-end">
                  <div>
                    <div className="text-[9px] text-white/25 uppercase tracking-widest mb-1.5 text-right">{m.teamB.name}</div>
                    <div className="flex justify-end -space-x-1.5">
                      {m.teamB.players.slice(0, 5).map(pid => {
                        const p = getPlayer(pid);
                        return (
                          <div 
                            key={pid} 
                            className="w-6 h-6 rounded-full flex items-center justify-center text-[8px] font-black border border-background font-title" 
                            style={{ background: p.color + "33", color: p.color }}
                          >
                            {initials(p.nick)}
                          </div>
                        );
                      })}
                    </div>
                  </div>
                </div>
              </div>
              <div className="flex items-center justify-between mt-4 pt-3 border-t border-white/5">
                <span className={`text-[10px] font-bold uppercase tracking-widest ${dr ? "text-white/30" : "text-[#00E87A]"}`}>
                  {dr ? "🤝 Empate" : `🏆 Vitória ${winner.name}`}
                </span>
                <div className="flex items-center gap-1 text-white/20">
                  <span className="text-[10px]">Detalhes</span>
                  <ChevronRight className="w-3 h-3" />
                </div>
              </div>
            </div>
          );
        })
      }
    </div>
  );
}