
public enum MovieTag {
	Comedy, SciFi, Horror, Action, Drama, Mystery;
	public static int tagToIndex(MovieTag tag)
	{
		switch(tag)
		{
		case Comedy:
			return 0;
		case SciFi:
		return 1;
		case Horror:
			return 2;
		case Action:
			return 3;
		case Drama:
			return 4;
		case Mystery:
			return 5;
		}
	}

}
