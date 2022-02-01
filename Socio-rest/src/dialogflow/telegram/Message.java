package dialogflow.telegram;

import java.util.List;

public class Message {
    private int message_id;
    private User from;
    private int date; 
    private Chat chat; 
    private User forward_from;
    private Chat forward_from_chat;
    private String forward_signature;
    private Integer forward_date;
    private Message reply_to_message;
    private int edit_date;
    private String media_group_id;
    private String author_signature;
    private String text; 
    private List<MessageEntity> entities;
    private List<MessageEntity> captionEntities;
    private Audio audio; 
    private Document document; 
    private Animation animation;
    private Game game;
    private List<PhotoSize> photo; 
    private Sticker sticker; 
    private Video video; 
    private Voice voice;
    private VideoNote video_Note;
    private String caption;
    private Contact contact; 
    private Location location; 
    private Venue venue; 
    private List<User> new_chat_members; 
    private User left_chat_member; 
    private String new_chat_title; 
    private List<PhotoSize> new_chat_photo; 
    private Boolean delete_chat_photo; 
    private Boolean group_chat_created; 
    private boolean supergroup_chat_created;
    private boolean channel_chat_created;
    private int migrate_to_chat_id;
    private int migrate_from_chat_id;
    private Message pinned_message;
    private Invoice invoice;
    private SuccessfulPayment successful_payment;
    private String connected_website;
    private PassportData passport_data; 
    
    public Message() {
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public User getForward_from() {
		return forward_from;
	}

	public void setForward_from(User forward_from) {
		this.forward_from = forward_from;
	}

	public Chat getForward_from_chat() {
		return forward_from_chat;
	}

	public void setForward_from_chat(Chat forward_from_chat) {
		this.forward_from_chat = forward_from_chat;
	}

	public String getForward_signature() {
		return forward_signature;
	}

	public void setForward_signature(String forward_signature) {
		this.forward_signature = forward_signature;
	}

	public Integer getForward_date() {
		return forward_date;
	}

	public void setForward_date(Integer forward_date) {
		this.forward_date = forward_date;
	}

	public Message getReply_to_message() {
		return reply_to_message;
	}

	public void setReply_to_message(Message reply_to_message) {
		this.reply_to_message = reply_to_message;
	}

	public int getEdit_date() {
		return edit_date;
	}

	public void setEdit_date(int edit_date) {
		this.edit_date = edit_date;
	}

	public String getMedia_group_id() {
		return media_group_id;
	}

	public void setMedia_group_id(String media_group_id) {
		this.media_group_id = media_group_id;
	}

	public String getAuthor_signature() {
		return author_signature;
	}

	public void setAuthor_signature(String author_signature) {
		this.author_signature = author_signature;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<MessageEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<MessageEntity> entities) {
		this.entities = entities;
	}

	public List<MessageEntity> getCaptionEntities() {
		return captionEntities;
	}

	public void setCaptionEntities(List<MessageEntity> captionEntities) {
		this.captionEntities = captionEntities;
	}

	public Audio getAudio() {
		return audio;
	}

	public void setAudio(Audio audio) {
		this.audio = audio;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public List<PhotoSize> getPhoto() {
		return photo;
	}

	public void setPhoto(List<PhotoSize> photo) {
		this.photo = photo;
	}

	public Sticker getSticker() {
		return sticker;
	}

	public void setSticker(Sticker sticker) {
		this.sticker = sticker;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	public VideoNote getVideo_Note() {
		return video_Note;
	}

	public void setVideo_Note(VideoNote video_Note) {
		this.video_Note = video_Note;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public List<User> getNew_chat_members() {
		return new_chat_members;
	}

	public void setNew_chat_members(List<User> new_chat_members) {
		this.new_chat_members = new_chat_members;
	}

	public User getLeft_chat_member() {
		return left_chat_member;
	}

	public void setLeft_chat_member(User left_chat_member) {
		this.left_chat_member = left_chat_member;
	}

	public String getNew_chat_title() {
		return new_chat_title;
	}

	public void setNew_chat_title(String new_chat_title) {
		this.new_chat_title = new_chat_title;
	}

	public List<PhotoSize> getNew_chat_photo() {
		return new_chat_photo;
	}

	public void setNew_chat_photo(List<PhotoSize> new_chat_photo) {
		this.new_chat_photo = new_chat_photo;
	}

	public Boolean getDelete_chat_photo() {
		return delete_chat_photo;
	}

	public void setDelete_chat_photo(Boolean delete_chat_photo) {
		this.delete_chat_photo = delete_chat_photo;
	}

	public Boolean getGroup_chat_created() {
		return group_chat_created;
	}

	public void setGroup_chat_created(Boolean group_chat_created) {
		this.group_chat_created = group_chat_created;
	}

	public boolean isSupergroup_chat_created() {
		return supergroup_chat_created;
	}

	public void setSupergroup_chat_created(boolean supergroup_chat_created) {
		this.supergroup_chat_created = supergroup_chat_created;
	}

	public boolean isChannel_chat_created() {
		return channel_chat_created;
	}

	public void setChannel_chat_created(boolean channel_chat_created) {
		this.channel_chat_created = channel_chat_created;
	}

	public int getMigrate_to_chat_id() {
		return migrate_to_chat_id;
	}

	public void setMigrate_to_chat_id(int migrate_to_chat_id) {
		this.migrate_to_chat_id = migrate_to_chat_id;
	}

	public int getMigrate_from_chat_id() {
		return migrate_from_chat_id;
	}

	public void setMigrate_from_chat_id(int migrate_from_chat_id) {
		this.migrate_from_chat_id = migrate_from_chat_id;
	}

	public Message getPinned_message() {
		return pinned_message;
	}

	public void setPinned_message(Message pinned_message) {
		this.pinned_message = pinned_message;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public SuccessfulPayment getSuccessful_payment() {
		return successful_payment;
	}

	public void setSuccessful_payment(SuccessfulPayment successful_payment) {
		this.successful_payment = successful_payment;
	}

	public String getConnected_website() {
		return connected_website;
	}

	public void setConnected_website(String connected_website) {
		this.connected_website = connected_website;
	}

	public PassportData getPassport_data() {
		return passport_data;
	}

	public void setPassport_data(PassportData passport_data) {
		this.passport_data = passport_data;
	}
    
    
    
}
