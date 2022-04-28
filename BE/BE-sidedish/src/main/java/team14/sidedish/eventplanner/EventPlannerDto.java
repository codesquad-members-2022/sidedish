package team14.sidedish.eventplanner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import team14.sidedish.menu.MenuModel;

public class EventPlannerDto {
	@Data
	@AllArgsConstructor
	public static class Ids {
		private final List<Id> menuAndEventId;

		public List<Long> getEventIds() {
			return this.menuAndEventId.stream()
				.map(EventPlannerDto.Id::getEventId)
				.collect(Collectors.toList());
		}

		public Optional<Id> findOngoingEvent(MenuModel menuModel) {
			return this.menuAndEventId.stream()
				.parallel()
				.filter(id -> id.getMenuId() == menuModel.getMenuId())
				.findAny();
		}
	}

	@Data
	@AllArgsConstructor
	public static class Id {
		private final Long menuId;
		private final Long eventId;
	}
}
