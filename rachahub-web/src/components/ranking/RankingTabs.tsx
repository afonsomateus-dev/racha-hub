import type { RankingTabsProps } from "../../types/ranking";

export const RankingTabs = ({ tabs, onSelect, currentTab }: RankingTabsProps) => {
  return (
    <div className="flex gap-1.5 overflow-x-auto -mx-4 px-4 pb-0.5" style={{ scrollbarWidth: "none" }}>
      {tabs.map(t => (
        <button
          key={t.id}
          onClick={() => onSelect(t.id)}
          className={`font-title shrink-0 flex items-center gap-1.5 px-3 py-2 rounded-xl text-xs font-bold transition-all active:scale-95 ${currentTab === t.id ? "bg-[#00E87A] text-black" : "bg-white/5 text-white/40 hover:bg-white/8"}`}
        >
          <span>{t.icon}</span>
          <span>{t.label}</span>
        </button>
      ))}
    </div>
  );
}