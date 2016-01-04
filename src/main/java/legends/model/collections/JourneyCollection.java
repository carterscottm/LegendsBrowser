package legends.model.collections;

import legends.model.World;
import legends.model.collections.basic.EventCollection;
import legends.model.events.HfSimpleBattleEvent;
import legends.model.events.HfTravelEvent;

public class JourneyCollection extends EventCollection {
	private int calcHfId = -1;

	public int getCalcHfId() {
		return calcHfId;
	}

	public void setCalcHfId(int calcHfId) {
		this.calcHfId = calcHfId;
	}

	@Override
	public boolean setProperty(String property, String value) {
		switch (property) {
		default:
			return super.setProperty(property, value);
		}
	}

	@Override
	public void process() {
		if (calcHfId == -1)
			getHistoricalEvents().stream().filter(e -> e instanceof HfTravelEvent).map(e -> ((HfTravelEvent) e))
					.map(HfTravelEvent::getHfId).findFirst().ifPresent(this::setCalcHfId);
	}

	@Override
	public String getShortDescription() {
		String hf = "UNKNOWN HISTORICAL FIGURE";
		if (calcHfId != -1)
			hf = World.getHistoricalFigure(calcHfId).getLink();
		return "the Journey of " + hf + " occurred";
	}
}