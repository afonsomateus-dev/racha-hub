import { Av, Dot, Medal, Pos } from "../../atoms";
import type { Player } from "../../types/player";
import type { RankingTopPositionsProps } from "../../types/ranking";
import { winRate } from "../../utils/helpers";

export const RankingTopPositions = ({ players, currentTab }: RankingTopPositionsProps) => {
  const sorted = [...players].sort((a, b) => {
    if (currentTab === "wins") return b.wins - a.wins;
    if (currentTab === "goals") return b.goals - a.goals;
    if (currentTab === "apps") return b.apps - a.apps;
    if (currentTab === "rate") return winRate(b) - winRate(a);
    return b.streak - a.streak;
  });

  const val = (p: Player) => {
    if (currentTab === "wins") return `${p.wins}V`;
    if (currentTab === "goals") return `${p.goals}⚽`;
    if (currentTab === "apps") return `${p.apps}J`;
    if (currentTab === "rate") return `${winRate(p)}%`;
    return `${p.streak}🔥`;
  };

  const [top1, top2, top3, ...rest] = sorted;

  return (
    <div className="flex flex-col gap-2">
      <div
        className="rounded-2xl p-4 cursor-pointer active:scale-[0.98] transition-transform"
        style={{ background: "linear-gradient(145deg, #1e1b0e, #131108)", border: "1px solid rgba(255,184,0,0.3)" }}
        onClick={() => {}}
      >
        <div className="flex items-center gap-3">
          <Medal rank={1} />
          <Av player={top1} size="lg" />
          <div className="flex-1 min-w-0">
            <div className="flex items-center gap-2 mb-0.5">
              <span className="text-xl font-black text-white truncate font-title">{top1.nick}</span>
              <Pos pos={top1.pos} />
            </div>
            <div className="flex items-center gap-1">
              {top1.lastResults.map((r, i) => <Dot key={i} r={r} />)}
            </div>
          </div>
          <div className="text-right shrink-0">
            <div className="text-2xl font-black text-[#FFB800] leading-none font-title">{val(top1)}</div>
          </div>
        </div>
      </div>

      <div
        className="rounded-2xl p-4 cursor-pointer active:scale-[0.98] transition-transform"
        style={{ background: "#141419", border: "1px solid rgba(192,192,192,0.14)" }}
        onClick={() => {}}
      >
        <div className="flex items-center gap-3">
          <Medal rank={2} />
          <Av player={top2} size="md" />
          <div className="flex-1 min-w-0">
            <div className="flex items-center gap-2">
              <span className="text-lg font-black text-white truncate font-title">{top2.nick}</span>
              <Pos pos={top2.pos} />
            </div>
          </div>
          <div className="text-xl font-black text-white/60 shrink-0 font-title">{val(top2)}</div>
        </div>
      </div>

      <div
        className="rounded-2xl p-4 cursor-pointer active:scale-[0.98] transition-transform"
        style={{ background: "#141419", border: "1px solid rgba(205,127,50,0.14)" }}
        onClick={() => {}}
      >
        <div className="flex items-center gap-3">
          <Medal rank={3} />
          <Av player={top3} size="md" />
          <div className="flex-1 min-w-0">
            <div className="flex items-center gap-2">
              <span className="text-lg font-black text-white truncate font-title">{top3.nick}</span>
              <Pos pos={top3.pos} />
            </div>
          </div>
          <div className="text-xl font-black text-white/60 shrink-0 font-title">{val(top3)}</div>
        </div>
      </div>

      <div className="flex flex-col gap-1.5 mt-1">
        {rest.map((p, i) => (
          <div
            key={p.id}
            className="flex items-center gap-3 px-3 py-2.5 rounded-xl cursor-pointer active:scale-[0.98] transition-transform"
            style={{ background: "#0e0e13", border: "1px solid rgba(255,255,255,0.04)" }}
            onClick={() => {}}
          >
            <span className="text-xs text-white/25 font-bold w-5 text-center font-title">{i + 4}</span>
            <Av player={p} size="sm" />
            <div className="flex-1 min-w-0">
              <span className="text-sm font-bold text-white/75 truncate block font-title">{p.nick}</span>
            </div>
            <span className="text-sm font-black text-white/50 shrink-0 font-title">{val(p)}</span>
          </div>
        ))}
      </div>
    </div>
  );
}