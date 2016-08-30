package com.agilent.sparklink.usersskills.events;

import org.apache.log4j.Logger;

import com.atlassian.confluence.event.events.security.LoginEvent;
import com.atlassian.confluence.event.events.security.LogoutEvent;
import com.atlassian.event.Event;
import com.atlassian.event.EventListener;

public class SkillEventListener implements EventListener {
	private static final Logger log = Logger.getLogger(SkillEventListener.class);

	private Class[] handledClasses = new Class[] { LoginEvent.class, LogoutEvent.class,
			com.atlassian.confluence.event.events.content.page.PageCreateEvent.class };


	@Override
	public void handleEvent(Event event) {
		System.out.println(
				"============================================================================================");
		System.out.println(event.getClass());
		log.error(event);
		if (event instanceof LoginEvent) {
			LoginEvent loginEvent = (LoginEvent) event;
			log.info(loginEvent.getUsername() + " logged in (" + loginEvent.getSessionId() + ")");
		} else if (event instanceof LogoutEvent) {
			LogoutEvent logoutEvent = (LogoutEvent) event;
			log.info(logoutEvent.getUsername() + " logged out (" + logoutEvent.getSessionId() + ")");
		}
		if (event instanceof com.atlassian.confluence.content.event.PluginContentCreatedEvent) {
			System.out.println("!!!!!!!!!!!!!!!!!!!! YOUHOU !!!!!!!!!!!!!!!!!!!!!!!");
		}
		if (event instanceof com.atlassian.confluence.event.events.label.LabelEvent) {
			System.out.println(((com.atlassian.confluence.event.events.label.LabelEvent) event).getLabel());
			System.out.println(((com.atlassian.confluence.event.events.label.LabelEvent) event).getLabelled());
		}
		System.out.println("----------------------------------------");
	}

	@Override
	public Class[] getHandledEventClasses() {
		return new Class[0];// handledClasses;
	}

}