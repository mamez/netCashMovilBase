
package com.bbva.pibee.aso.noti.dto;



public class Notification 
{

    private String title;
    private String body;
    private String sound;
    private String badge;
    private String iconName;
    private Boolean contentAvailable;
	private String tag;
    private String color;
    private String action;

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String value) {
        this.body = value;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String value) {
        this.sound = value;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String value) {
        this.badge = value;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String value) {
        this.iconName = value;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String value) {
        this.tag = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String value) {
        this.color = value;
    }
    
  
    public String getAction() {
        return action;
    }

    public void setAction(String value) {
        this.action = value;
    }

	public Boolean getContentAvailable() {
		return contentAvailable;
	}

	public void setContentAvailable(Boolean contentAvailable) {
		this.contentAvailable = contentAvailable;
	}

}
