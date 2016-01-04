package legends.xml;

import java.util.function.Consumer;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import legends.model.EntityReputation;
import legends.xml.handlers.XMLContentHandler;

public class EntityReputationContentHandler extends XMLContentHandler {

	EntityReputation entityLink = new EntityReputation();
	Consumer<EntityReputation> handler;

	public EntityReputationContentHandler(String name, XMLReader xmlReader, Consumer<EntityReputation> handler) {
		super(name, xmlReader);
		this.handler = handler;
		setHandledValues("entity_id", "first_ageless_year", "first_ageless_season_count", "unsolved_murders");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (localName) {
		case "entity_id":
			entityLink.setEntityId(Integer.parseInt(value));
			break;
		case "first_ageless_year":
			entityLink.setFirstAgelessYear(Integer.parseInt(value));
			break;
		case "first_ageless_season_count":
			entityLink.setFirstAgelessSeasonCount(Integer.parseInt(value));
			break;
		case "unsolved_murders":
			entityLink.setUnsolvedMurders(Integer.parseInt(value));
			break;
		default:
			super.endElement(uri, localName, qName);
			break;
		}
	}

	@Override
	protected void popContentHandler() {
		handler.accept(entityLink);
		entityLink = new EntityReputation();
		super.popContentHandler();
	}
}