package tool;

import jakarta.servlet.http.*;

public abstract class Action {
	public abstract String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception;
}
