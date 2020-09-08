package com.example.octoevents.domain.repository

import com.example.octoevents.domain.issue.*
import com.example.octoevents.domain.repository.IssueEvents.nullable
import com.example.octoevents.domain.repository.IssueEvents.references
import com.example.octoevents.domain.repository.Repositorys.nullable
import com.example.octoevents.domain.repository.Repositorys.references
import com.fasterxml.jackson.annotation.JsonProperty
import org.jetbrains.exposed.dao.LongIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import javax.sql.DataSource


internal object IssueEvents : LongIdTable("issue_event") {
    var action = varchar("ref", 255).nullable()
    var issueId = long("issue_id").references(Issues.id).nullable()
    var changeId = (varchar("change_id", 255) references Changes.bodyId).nullable()
    val repositoryId = long("repository_id").references(Repositorys.id).nullable()
    var senderId = long("sender_id").references(Senders.id).nullable()
}

internal object Repositorys : Table("repository") {
    var id = long("id").uniqueIndex().primaryKey()
    var nodeId = varchar("node_id", 255).nullable()
    var name = varchar("name", 255).nullable()
    var fullName = varchar("full_name", 255).nullable()
    var _private = bool("private").nullable()
    var ownerId = long("owner_id").references(Owners.id).nullable()
    var htmlUrl = varchar("html_url", 255).nullable()
    var description = varchar("description", 255).nullable()
    var fork = bool("fork").nullable()
    var url = varchar("url", 255).nullable()
    var forksUrl = varchar("forks_url", 255).nullable()
    var keysUrl = varchar("keys_url", 255).nullable()
    var collaboratorsUrl = varchar("collaborators_url", 255).nullable()
    var teamsUrl = varchar("teams_url", 255).nullable()
    var hooksUrl = varchar("hooks_url", 255).nullable()
    var issueEventsUrl = varchar("issueEvents_url", 255).nullable()
    var eventsUrl = varchar("events_url", 255).nullable()
    var assigneesUrl = varchar("assignees_url", 255).nullable()
    var branchesUrl = varchar("branches_url", 255).nullable()
    var tagsUrl = varchar("tags_url", 255).nullable()
    var blobsUrl = varchar("blobs_url", 255).nullable()
    var gitTagsUrl = varchar("git_tags_url", 255).nullable()
    var gitRefsUrl = varchar("git_refs_url", 255).nullable()
    var treesUrl = varchar("trees_url", 255).nullable()
    var statusesUrl = varchar("statuses_url", 255).nullable()
    var languagesUrl = varchar("languages_url", 255).nullable()
    var stargazersUrl = varchar("stargazers_url", 255).nullable()
    var contributorsUrl = varchar("contributors_url", 255).nullable()
    var subscribersUrl = varchar("subscribers_url", 255).nullable()
    var subscriptionUrl = varchar("subscription_url", 255).nullable()
    var commitsUrl = varchar("commits_url", 255).nullable()
    var gitCommitsUrl = varchar("git_commits_url", 255).nullable()
    var commentsUrl = varchar("comments_url", 255).nullable()
    var issueCommentUrl = varchar("issue_comment_url", 255).nullable()
    var contentsUrl = varchar("contents_url", 255).nullable()
    var compareUrl = varchar("compare_url", 255).nullable()
    var mergesUrl = varchar("merges_url", 255).nullable()
    var archiveUrl = varchar("archive_url", 255).nullable()
    var downloadsUrl = varchar("downloads_url", 255).nullable()
    var issuesUrl = varchar("issues_url", 255).nullable()
    var pullsUrl = varchar("pulls_url", 255).nullable()
    var milestonesUrl = varchar("milestones_url", 255).nullable()
    var notificationsUrl = varchar("notifications_url", 255).nullable()
    var labelsUrl = varchar("labels_url", 255).nullable()
    var releasesUrl = varchar("releases_url", 255).nullable()
    var deploymentsUrl = varchar("deployments_url", 255).nullable()
    var createdAt = varchar("created_at", 255).nullable()
    var updatedAt = varchar("updated_at", 255).nullable()
    var pushedAt = varchar("pushed_at", 255).nullable()
    var gitUrl = varchar("git_url", 255).nullable()
    var sshUrl = varchar("ssh_url", 255).nullable()
    var cloneUrl = varchar("clone_url", 255).nullable()
    var svnUrl = varchar("svn_url", 255).nullable()
    var homepage = varchar("homepage", 255).nullable()
    var size = long("size").nullable()
    var stargazersCount = long("stargazers_count").nullable()
    var watchersCount = long("watchers_count").nullable()
    var language = varchar("language", 255).nullable()
    var hasIssues = bool("has_issues").nullable()
    var hasProjects = bool("has_projects").nullable()
    var hasDownloads = bool("has_downloads").nullable()
    var hasWiki = bool("has_wiki").nullable()
    var hasPages = bool("has_pages").nullable()
    var forksCount = long("forks_count").nullable()
    var mirrorUrl = varchar("mirror_url", 255).nullable()
    var archived = bool("archived").nullable()
    var disabled = bool("disabled").nullable()
    var openIssuesCount = long("open_issues_count").nullable()
    var licenseId = (varchar("license_id", 255) references Licenses.nodeId).nullable()
    var forks = long("forks").nullable()
    var openIssues = long("openIssues").nullable()
    var watchers = long("watchers").nullable()
    var defaultBranch = varchar("default_branch", 255).nullable()
}

internal object Issues : Table("issue") {

    var id = long("id").uniqueIndex().primaryKey(0)
    var url = varchar("url", 255).nullable()
    var repositoryUrl = varchar("repository_url", 255).nullable()
    var labelsUrl = varchar("labels_url", 255).nullable()
    var activeLockReason = varchar("active_lock_reason", 255).nullable()
    var performedViaGithubApp = varchar("performed_via_github_app", 255).nullable()
    var commentsUrl = varchar("comments_url", 255).nullable()
    var eventsUrl = varchar("events_url", 255).nullable()
    var htmlUrl = varchar("html_url", 255).nullable()
    var nodeId = varchar("node_id", 255).nullable()
    var number = long("number")
    var title = varchar("title", 255).nullable()
    var userId = long("user_id").references(Users.id).nullable()
    var state = varchar("state", 255).nullable()
    var locked = bool("locked").nullable()
    var assigneeId = long("assignee_id").references(Assignees.id).nullable()
    var milestoneId = long("milestone_id").references(Milestones.id).nullable()
    var comments = long("comments").nullable()
    var createdAt = varchar("created_at", 255).nullable()
    var updatedAt = varchar("updated_at", 255).nullable()
    var closedAt = varchar("closed_at", 255).nullable()
    var authorAssociation = varchar("author_association", 255).nullable()
    var body = varchar("body", 255).nullable()

}

internal object Users : Table("user") {
    var id = long("id").uniqueIndex().primaryKey(0)
    var login = varchar("login", 255).nullable()
    var nodeId = varchar("nodeId", 255).nullable()
    var avatarUrl = varchar("avatar_url", 255).nullable()
    var gravatarId = varchar("gravatar_id", 255).nullable()
    var url = varchar("url", 255).nullable()
    var htmlUrl = varchar("html_url", 255).nullable()
    var followersUrl = varchar("followers_url", 255).nullable()
    var followingUrl = varchar("following_url", 255).nullable()
    var gistsUrl = varchar("gists_url", 255).nullable()
    var starredUrl = varchar("starred_url", 255).nullable()
    var subscriptionsUrl = varchar("subscriptions_url", 255).nullable()
    var organizationsUrl = varchar("organizations_url", 255).nullable()
    var reposUrl = varchar("repos_url", 255).nullable()
    var eventsUrl = varchar("events_url", 255).nullable()
    var receivedEventsUrl = varchar("received_events_url", 255).nullable()
    var type = varchar("type", 255).nullable()
    var siteAdmin = bool("site_admin").nullable()
}

internal object IssuesLabels : Table("issue_label") {
    val issueId = long("issue_id").primaryKey(0)
    val labeld = long("label_id").primaryKey(1)
}

internal object Labels : Table("label") {
    var id = long("id").uniqueIndex().primaryKey(0)
    var nodeId = varchar("node_id", 255).nullable()
    var url = varchar("url", 255).nullable()
    var name = varchar("name", 255).nullable()
    var color = varchar("color", 255).nullable()
    var _default = bool("default").nullable()
}

internal object Assignees : Table("assignee") {
    var id = long("id").uniqueIndex().primaryKey(0)
    var login = varchar("login", 255).nullable()
    var nodeId = varchar("node_id", 255).nullable()
    var avatarUrl = varchar("avatar_url", 255).nullable()
    var gravatarId = varchar("gravatar_id", 255).nullable()
    var url = varchar("url", 255).nullable()
    var htmlUrl = varchar("html_url", 255).nullable()
    var followersUrl = varchar("followers_url", 255).nullable()
    var followingUrl = varchar("following_url", 255).nullable()
    var gistsUrl = varchar("gists_url", 255).nullable()
    var starredUrl = varchar("starred_url", 255).nullable()
    var subscriptionsUrl = varchar("subscriptions_url", 255).nullable()
    var organizationsUrl = varchar("organizations_url", 255).nullable()
    var reposUrl = varchar("repos_url", 255).nullable()
    var eventsUrl = varchar("events_url", 255).nullable()
    var receivedEventsUrl = varchar("received_events_url", 255).nullable()
    var type = varchar("type", 255).nullable()
    var siteAdmin = bool("site_admin").nullable()
}

internal object IssuesAssignees : Table("issue_assignee") {
    val issueId = long("issue_id").primaryKey(0)
    val assigneeld = long("assignee_id").primaryKey(1)
}

internal object Milestones : Table("milestone") {
    var id = long("id").uniqueIndex().primaryKey(0)
    var url = varchar("url", 255).nullable()
    var htmlUrl = varchar("html_url", 255).nullable()
    var labelsUrl = varchar("labels_url", 255).nullable()
    var nodeId = varchar("node_id", 255).nullable()
    var number = long("number").nullable()
    var title = varchar("title", 255).nullable()
    var description = varchar("description", 255).nullable()
    var creatorId = long("creator_id").references(Creators.id).nullable()
    var openIssues = long("open_issues").nullable()
    var closedIssues = long("closed_issues").nullable()
    var state = varchar("state", 255).nullable()
    var createdAt = varchar("created_at", 255).nullable()
    var updatedAt = varchar("updated_at", 255).nullable()
    var dueOn = varchar("due_on", 255).nullable()
    var closedAt = varchar("closed_at", 255).nullable()
}

internal object Creators : Table("creator") {
    var id = long("id").uniqueIndex().primaryKey(0)
    var login = varchar("login", 255).nullable()
    var nodeId = varchar("node_id", 255).nullable()
    var avatarUrl = varchar("avatar_url", 255).nullable()
    var gravatarId = varchar("gravatar_id", 255).nullable()
    var url = varchar("url", 255).nullable()
    var htmlUrl = varchar("html_url", 255).nullable()
    var followersUrl = varchar("followers_url", 255).nullable()
    var followingUrl = varchar("following_url", 255).nullable()
    var gistsUrl = varchar("gists_url", 255).nullable()
    var starredUrl = varchar("starred_url", 255).nullable()
    var subscriptionsUrl = varchar("subscriptions_url", 255).nullable()
    var organizationsUrl = varchar("organizations_url", 255).nullable()
    var reposUrl = varchar("repos_url", 255).nullable()
    var eventsUrl = varchar("events_url", 255).nullable()
    var receivedEventsUrl = varchar("received_events_url", 255).nullable()
    var type = varchar("type", 255).nullable()
    var siteAdmin = bool("site_admin").nullable()
}

internal object Owners : Table("owner") {
    var id = long("id").uniqueIndex().primaryKey(0)
    var name = varchar("name", 255).nullable()
    var email = varchar("email", 255).nullable()
    var login = varchar("login", 255).nullable()
    var nodeId = varchar("node_id", 255).nullable()
    var avatarUrl = varchar("avatar_url", 255).nullable()
    var gravatarId = varchar("gravatar_id", 255).nullable()
    var url = varchar("url", 255).nullable()
    var htmlUrl = varchar("html_url", 255).nullable()
    var followersUrl = varchar("followers_url", 255).nullable()
    var followingUrl = varchar("following_url", 255).nullable()
    var gistsUrl = varchar("gists_url", 255).nullable()
    var starredUrl = varchar("starred_url", 255).nullable()
    var subscriptionsUrl = varchar("subscriptions_url", 255).nullable()
    var organizationsUrl = varchar("organizations_url", 255).nullable()
    var reposUrl = varchar("repos_url", 255).nullable()
    var eventsUrl = varchar("events_url", 255).nullable()
    var receivedEventsUrl = varchar("received_events_url", 255).nullable()
    var type = varchar("type", 255).nullable()
    var siteAdmin = bool("site_admin").nullable()
}

internal object Licenses : Table("license") {
    var nodeId = varchar("node_id", 255).uniqueIndex().primaryKey(0)
    var key = varchar("key", 255).nullable()
    var name = varchar("name", 255).nullable()
    var spdxId = varchar("spdx_id", 255).nullable()
    var url = varchar("url", 255).nullable()

}

internal object Changes : Table("change") {
    var bodyId = varchar("body_id", 255).primaryKey().references(Bodys.from)
}

internal object Bodys : Table("body") {
    var from = varchar("from", 255).primaryKey()
}

internal object Senders : Table("sender") {
    var id = long("id").uniqueIndex().primaryKey(0)
    var login = varchar("login", 255).nullable()
    var nodeId = varchar("node_id", 255).nullable()
    var avatarUrl = varchar("avatar_url", 255).nullable()
    var gravatarId = varchar("gravatar_id", 255).nullable()
    var url = varchar("url", 255).nullable()
    var htmlUrl = varchar("html_url", 255).nullable()
    var followersUrl = varchar("followers_url", 255).nullable()
    var followingUrl = varchar("following_url", 255).nullable()
    var gistsUrl = varchar("gists_url", 255).nullable()
    var starredUrl = varchar("starred_url", 255).nullable()
    var subscriptionsUrl = varchar("subscriptions_url", 255).nullable()
    var organizationsUrl = varchar("organizations_url", 255).nullable()
    var reposUrl = varchar("repos_url", 255).nullable()
    var eventsUrl = varchar("events_url", 255).nullable()
    var receivedEventsUrl = varchar("received_events_url", 255).nullable()
    var type = varchar("type", 255).nullable()
    var siteAdmin = bool("site_admin").nullable()
}

fun toDomain(row: ResultRow): IssueEvent {
    return IssueEvent(
        id = row[IssueEvents.id].value,
        action = row[IssueEvents.action],
        issue = row[IssueEvents.issueId]?.let { getIssue(row) } ,
        changes = row[IssueEvents.changeId]?.let { getChanges(row) },
        sender = row[IssueEvents.senderId]?.let { getSender(row) },
        repository = row[IssueEvents.repositoryId]?.let {  getRepository(row) },
    )
}

private fun getIssue(row: ResultRow): Issue {
    return Issue(
        id = row[Issues.id],
        url = row[Issues.url],
        activeLockReason = row[Issues.activeLockReason],
        repositoryUrl = row[Issues.repositoryUrl],
        labelsUrl = row[Issues.labelsUrl],
        commentsUrl = row[Issues.commentsUrl],
        eventsUrl = row[Issues.eventsUrl],
        htmlUrl = row[Issues.htmlUrl],
        nodeId = row[Issues.nodeId],
        number = row[Issues.number],
        title = row[Issues.title],
        user = row[Issues.userId]?.let { getUser(row) } ,
        labels = getLabels(row),
        state = row[Issues.state],
        locked = row[Issues.locked],
        assignee = row[Issues.assigneeId]?.let { getAssignee(row) },
        assignees = getAssignees(row),
        milestone = row[Issues.milestoneId]?.let { getMilestone(row) },
        comments = row[Issues.comments],
        createdAt = row[Issues.createdAt],
        updatedAt = row[Issues.updatedAt],
        closedAt = row[Issues.closedAt],
        authorAssociation = row[Issues.authorAssociation],
        body = row[Issues.body]
    )
}

private fun getChanges(row: ResultRow): Change {
    return Change(
        Body(
            from = row[Bodys.from]
        )
    )
}

private fun getSender(row: ResultRow): Sender {
    return Sender(
        login = row[Senders.login],
        id = row[Senders.id],
        nodeId = row[Senders.nodeId],
        avatarUrl = row[Senders.avatarUrl],
        gravatarId = row[Senders.gravatarId],
        url = row[Senders.url],
        htmlUrl = row[Senders.htmlUrl],
        followersUrl = row[Senders.followersUrl],
        followingUrl = row[Senders.followingUrl],
        gistsUrl = row[Senders.gistsUrl],
        starredUrl = row[Senders.starredUrl],
        subscriptionsUrl = row[Senders.subscriptionsUrl],
        organizationsUrl = row[Senders.organizationsUrl],
        reposUrl = row[Senders.reposUrl],
        eventsUrl = row[Senders.eventsUrl],
        receivedEventsUrl = row[Senders.receivedEventsUrl],
        type = row[Senders.type],
        siteAdmin = row[Senders.siteAdmin]
    )
}

private fun getUser(row: ResultRow): User {
    return User(
        login = row[Users.login],
        id = row[Users.id],
        nodeId = row[Users.nodeId],
        avatarUrl = row[Users.avatarUrl],
        gravatarId = row[Users.gravatarId],
        url = row[Users.url],
        htmlUrl = row[Users.htmlUrl],
        followersUrl = row[Users.followersUrl],
        followingUrl = row[Users.followingUrl],
        gistsUrl = row[Users.gistsUrl],
        starredUrl = row[Users.starredUrl],
        subscriptionsUrl = row[Users.subscriptionsUrl],
        organizationsUrl = row[Users.organizationsUrl],
        reposUrl = row[Users.reposUrl],
        eventsUrl = row[Users.eventsUrl],
        receivedEventsUrl = row[Users.receivedEventsUrl],
        type = row[Users.type],
        siteAdmin = row[Users.siteAdmin]
    )
}

private fun getMilestone(row: ResultRow): Milestone {
    return Milestone(
        url = row[Milestones.url],
        htmlUrl = row[Milestones.htmlUrl],
        labelsUrl = row[Milestones.labelsUrl],
        id = row[Milestones.id],
        nodeId = row[Milestones.nodeId],
        number = row[Milestones.number],
        title = row[Milestones.title],
        description = row[Milestones.description],
        creator = getCreator(row),
        openIssues = row[Milestones.openIssues],
        closedIssues = row[Milestones.closedIssues],
        state = row[Milestones.state],
        createdAt = row[Milestones.createdAt],
        updatedAt = row[Milestones.updatedAt],
        dueOn = row[Milestones.dueOn],
        closedAt = row[Milestones.closedAt]
    )
}

private fun getCreator(row: ResultRow): Creator {
    return Creator(
        login = row[Creators.login],
        id = row[Creators.id],
        nodeId = row[Creators.nodeId],
        avatarUrl = row[Creators.avatarUrl],
        gravatarId = row[Creators.gravatarId],
        url = row[Creators.url],
        htmlUrl = row[Creators.htmlUrl],
        followersUrl = row[Creators.followersUrl],
        followingUrl = row[Creators.followingUrl],
        gistsUrl = row[Creators.gistsUrl],
        starredUrl = row[Creators.starredUrl],
        subscriptionsUrl = row[Creators.subscriptionsUrl],
        organizationsUrl = row[Creators.organizationsUrl],
        reposUrl = row[Creators.reposUrl],
        eventsUrl = row[Creators.eventsUrl],
        receivedEventsUrl = row[Creators.receivedEventsUrl],
        type = row[Creators.type],
        siteAdmin = row[Creators.siteAdmin]
    )
}

private fun getAssignee(row: ResultRow): Assignee {
    return Assignee(
        login = row[Assignees.login],
        id = row[Assignees.id],
        nodeId = row[Assignees.nodeId],
        avatarUrl = row[Assignees.avatarUrl],
        gravatarId = row[Assignees.gravatarId],
        url = row[Assignees.url],
        htmlUrl = row[Assignees.htmlUrl],
        followersUrl = row[Assignees.followersUrl],
        followingUrl = row[Assignees.followingUrl],
        gistsUrl = row[Assignees.gistsUrl],
        starredUrl = row[Assignees.starredUrl],
        subscriptionsUrl = row[Assignees.subscriptionsUrl],
        organizationsUrl = row[Assignees.organizationsUrl],
        reposUrl = row[Assignees.reposUrl],
        eventsUrl = row[Assignees.eventsUrl],
        receivedEventsUrl = row[Assignees.receivedEventsUrl],
        type = row[Assignees.type],
        siteAdmin = row[Assignees.siteAdmin],
    )
}

private fun getRepository(row: ResultRow): Repository {
    return Repository(
        id = row[Repositorys.id],
        nodeId = row[Repositorys.nodeId],
        name = row[Repositorys.name],
        fullName = row[Repositorys.fullName],
        _private = row[Repositorys._private],
        owner = row[Repositorys.ownerId]?.let { getOwner(row) },
        htmlUrl = row[Repositorys.htmlUrl],
        description = row[Repositorys.description],
        fork = row[Repositorys.fork],
        url = row[Repositorys.url],
        forksUrl = row[Repositorys.forksUrl],
        keysUrl = row[Repositorys.keysUrl],
        collaboratorsUrl = row[Repositorys.collaboratorsUrl],
        teamsUrl = row[Repositorys.teamsUrl],
        hooksUrl = row[Repositorys.hooksUrl],
        issueEventsUrl = row[Repositorys.issueEventsUrl],
        eventsUrl = row[Repositorys.eventsUrl],
        assigneesUrl = row[Repositorys.assigneesUrl],
        branchesUrl = row[Repositorys.branchesUrl],
        tagsUrl = row[Repositorys.tagsUrl],
        blobsUrl = row[Repositorys.blobsUrl],
        gitTagsUrl = row[Repositorys.gitTagsUrl],
        gitRefsUrl = row[Repositorys.gitRefsUrl],
        treesUrl = row[Repositorys.treesUrl],
        statusesUrl = row[Repositorys.statusesUrl],
        languagesUrl = row[Repositorys.languagesUrl],
        stargazersUrl = row[Repositorys.stargazersUrl],
        contributorsUrl = row[Repositorys.contributorsUrl],
        subscribersUrl = row[Repositorys.subscribersUrl],
        subscriptionUrl = row[Repositorys.subscriptionUrl],
        commitsUrl = row[Repositorys.commitsUrl],
        gitCommitsUrl = row[Repositorys.gitCommitsUrl],
        commentsUrl = row[Repositorys.commentsUrl],
        issueCommentUrl = row[Repositorys.issueCommentUrl],
        contentsUrl = row[Repositorys.contentsUrl],
        compareUrl = row[Repositorys.compareUrl],
        mergesUrl = row[Repositorys.mergesUrl],
        archiveUrl = row[Repositorys.archiveUrl],
        downloadsUrl = row[Repositorys.downloadsUrl],
        issuesUrl = row[Repositorys.issuesUrl],
        pullsUrl = row[Repositorys.pullsUrl],
        milestonesUrl = row[Repositorys.milestonesUrl],
        notificationsUrl = row[Repositorys.notificationsUrl],
        labelsUrl = row[Repositorys.labelsUrl],
        releasesUrl = row[Repositorys.releasesUrl],
        deploymentsUrl = row[Repositorys.deploymentsUrl],
        createdAt = row[Repositorys.createdAt],
        updatedAt = row[Repositorys.updatedAt],
        pushedAt = row[Repositorys.pushedAt],
        gitUrl = row[Repositorys.gitUrl],
        sshUrl = row[Repositorys.sshUrl],
        cloneUrl = row[Repositorys.cloneUrl],
        svnUrl = row[Repositorys.svnUrl],
        homepage = row[Repositorys.homepage],
        size = row[Repositorys.size],
        stargazersCount = row[Repositorys.stargazersCount],
        watchersCount = row[Repositorys.watchersCount],
        language = row[Repositorys.language],
        hasIssues = row[Repositorys.hasIssues],
        hasProjects = row[Repositorys.hasProjects],
        hasDownloads = row[Repositorys.hasDownloads],
        hasWiki = row[Repositorys.hasWiki],
        hasPages = row[Repositorys.hasPages],
        forksCount = row[Repositorys.forksCount],
        mirrorUrl = row[Repositorys.mirrorUrl],
        archived = row[Repositorys.archived],
        disabled = row[Repositorys.disabled],
        openIssuesCount = row[Repositorys.openIssuesCount],
        license = row[Repositorys.licenseId]?.let { getLicense(row) },
        forks = row[Repositorys.forks],
        openIssues = row[Repositorys.openIssues],
        watchers = row[Repositorys.watchers],
        defaultBranch = row[Repositorys.defaultBranch]
    )
}

private fun getAssignees(row: ResultRow): MutableList<Assignee> {
    return Assignees
        .join(IssuesAssignees, JoinType.INNER, additionalConstraint = { IssuesAssignees.issueId eq row[Issues.id] })
        .select { IssuesAssignees.issueId eq row[Issues.id] }
        .map { getAssignee(it) }
        .toMutableList()
}

private fun getLabel(row: ResultRow): Label {
    return Label(
        id = row[Labels.id],
        nodeId = row[Labels.nodeId],
        url = row[Labels.url],
        name = row[Labels.name],
        color = row[Labels.color],
        _default = row[Labels._default]
    )
}

private fun getLicense(row: ResultRow): License {
    return License(
        key = row[Licenses.key],
        name = row[Licenses.name],
        spdxId = row[Licenses.spdxId],
        url = row[Licenses.url],
        nodeId = row[Licenses.nodeId]
    )
}

private fun getLabels(row: ResultRow): MutableList<Label> {
    return Labels
        .join(IssuesLabels, JoinType.INNER, additionalConstraint = { IssuesLabels.issueId eq row[Issues.id] })
        .select { IssuesLabels.issueId eq row[Issues.id] }
        .map { getLabel(it) }
        .toMutableList()
}

private fun getOwner(row: ResultRow): Owner {
    return Owner(
        //name = row[Owners.name],
        //email = row[Owners.email],
        login = row[Owners.login],
        id = row[Owners.id],
        nodeId = row[Owners.nodeId],
        avatarUrl = row[Owners.avatarUrl],
        gravatarId = row[Owners.gravatarId],
        url = row[Owners.url],
        htmlUrl = row[Owners.htmlUrl],
        followersUrl = row[Owners.followersUrl],
        followingUrl = row[Owners.followingUrl],
        gistsUrl = row[Owners.gistsUrl],
        starredUrl = row[Owners.starredUrl],
        subscriptionsUrl = row[Owners.subscriptionsUrl],
        organizationsUrl = row[Owners.organizationsUrl],
        reposUrl = row[Owners.reposUrl],
        eventsUrl = row[Owners.eventsUrl],
        receivedEventsUrl = row[Owners.receivedEventsUrl],
        type = row[Owners.type],
        siteAdmin = row[Owners.siteAdmin]
    )
}

class IssueEventRepository(private val dataSource: DataSource) {

    init {
        transaction(Database.connect(dataSource)) {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(IssueEvents)
            SchemaUtils.create(IssuesAssignees)
            SchemaUtils.create(Labels)
            SchemaUtils.create(IssuesLabels)
        }
    }

    /**
     * Cria o evento
     */
    fun create(issuesEvent: IssueEvent) {
        return transaction(Database.connect(dataSource)) {
            addLogger(StdOutSqlLogger)

            // Event
            insertEvent(issuesEvent)

            issuesEvent.issue?.let { insertLabels(it) }

            issuesEvent.issue?.let { insertsAssignees(it) }

        }
    }

    /**
     * Retorna o evento por id
     */
    fun findById(id: Long): IssueEvent? {
        return transaction(Database.connect(dataSource)) {
            addLogger(StdOutSqlLogger)
            IssueEvents
                .join(Issues, JoinType.LEFT, additionalConstraint = { IssueEvents.issueId eq Issues.id })
                .join(Repositorys, JoinType.LEFT, additionalConstraint = { IssueEvents.repositoryId eq Repositorys.id })
                .join(Licenses, JoinType.LEFT, additionalConstraint = { Repositorys.licenseId eq Licenses.nodeId })
                .join(Changes, JoinType.LEFT, additionalConstraint = { IssueEvents.changeId eq Changes.bodyId })
                .join(Bodys, JoinType.LEFT, additionalConstraint = { Changes.bodyId eq Bodys.from })
                .join(Owners, JoinType.LEFT, additionalConstraint = { Repositorys.ownerId eq Owners.id })
                .join(Senders, JoinType.LEFT, additionalConstraint = { IssueEvents.senderId eq Senders.id })
                .join(Users, JoinType.LEFT, additionalConstraint = { Issues.userId eq Users.id })
                .join(Assignees, JoinType.LEFT, additionalConstraint = { Issues.assigneeId eq Assignees.id })
                .join(Milestones, JoinType.LEFT, additionalConstraint = { Issues.milestoneId eq Milestones.id })
                .join(Creators, JoinType.LEFT, additionalConstraint = { Milestones.creatorId eq Creators.id })

                .select { IssueEvents.id eq id }
                .map { row -> toDomain(row) }
                .firstOrNull()
        }
    }

    private fun insertEvent(issueEvent: IssueEvent) {
        IssueEvents.insertAndGetId { row ->
            row[action] = issueEvent.action
            row[issueId] = issueEvent.issue?.let { insertIssue(it) }
            row[changeId] = issueEvent.changes?.let { insertChange(it) }
            row[repositoryId] = issueEvent.repository?.let { insertRepository(it) }
            row[senderId] = issueEvent.sender?.let { insertSender(it) }

        }.value
    }

    private fun insertIssue(issue: Issue): Long {
        return Issues.insert { row ->
            row[id] = issue.id
            row[url] = issue.url
            row[repositoryUrl] = issue.repositoryUrl
            row[activeLockReason] = issue.activeLockReason
            row[performedViaGithubApp] = issue.performedViaGithubApp
            row[labelsUrl] = issue.labelsUrl
            row[commentsUrl] = issue.commentsUrl
            row[eventsUrl] = issue.eventsUrl
            row[htmlUrl] = issue.htmlUrl
            row[nodeId] = issue.nodeId
            row[number] = issue.number!!
            row[title] = issue.title
            row[userId] = issue.user?.let { insertUser(it) }
            row[state] = issue.state
            row[locked] = issue.locked
            row[assigneeId] = issue.assignee?.let { insertAssignee(it) }
            row[milestoneId] = issue.milestone?.let { insertMilestone(it) }
            row[comments] = issue.comments
            row[createdAt] = issue.createdAt
            row[updatedAt] = issue.updatedAt
            row[closedAt] = issue.closedAt
            row[authorAssociation] = issue.authorAssociation
            row[body] = issue.body
        } get Issues.id
    }

    private fun insertUser(user: User): Long {
        return Users.insertIgnore { row ->
            row[id] = user.id
            row[login] = user.login
            row[nodeId] = user.nodeId
            row[avatarUrl] = user.avatarUrl
            row[gravatarId] = user.gravatarId
            row[url] = user.url
            row[htmlUrl] = user.htmlUrl
            row[followersUrl] = user.followersUrl
            row[followingUrl] = user.followingUrl
            row[gistsUrl] = user.gistsUrl
            row[starredUrl] = user.starredUrl
            row[subscriptionsUrl] = user.subscriptionsUrl
            row[organizationsUrl] = user.organizationsUrl
            row[reposUrl] = user.reposUrl
            row[eventsUrl] = user.eventsUrl
            row[receivedEventsUrl] = user.receivedEventsUrl
            row[type] = user.type
            row[siteAdmin] = user.siteAdmin
        } get Users.id
    }

    private fun insertAssignee(assignee: Assignee): Long {
        return Assignees.insertIgnore { row ->
            row[id] = assignee.id
            row[login] = assignee.login
            row[nodeId] = assignee.nodeId
            row[avatarUrl] = assignee.avatarUrl
            row[gravatarId] = assignee.gravatarId
            row[url] = assignee.url
            row[htmlUrl] = assignee.htmlUrl
            row[followersUrl] = assignee.followersUrl
            row[followingUrl] = assignee.followingUrl
            row[gistsUrl] = assignee.gistsUrl
            row[starredUrl] = assignee.starredUrl
            row[subscriptionsUrl] = assignee.subscriptionsUrl
            row[organizationsUrl] = assignee.organizationsUrl
            row[reposUrl] = assignee.reposUrl
            row[eventsUrl] = assignee.eventsUrl
            row[receivedEventsUrl] = assignee.receivedEventsUrl
            row[type] = assignee.type
            row[siteAdmin] = assignee.siteAdmin
        } get Assignees.id
    }

    private fun insertMilestone(milestone: Milestone): Long {
        return Milestones.insert { row ->
            row[id] = milestone.id
            row[url] = milestone.url
            row[htmlUrl] = milestone.htmlUrl
            row[labelsUrl] = milestone.labelsUrl
            row[nodeId] = milestone.nodeId
            row[number] = milestone.number
            row[title] = milestone.title
            row[description] = milestone.description
            row[creatorId] = milestone.creator?.let { insertCreator(it) }
            row[openIssues] = milestone.openIssues
            row[closedIssues] = milestone.closedIssues
            row[state] = milestone.state
            row[createdAt] = milestone.createdAt
            row[updatedAt] = milestone.updatedAt
            row[dueOn] = milestone.dueOn
            row[closedAt] = milestone.closedAt
        } get Milestones.id
    }

    private fun insertCreator(creator: Creator): Long {
        return Creators.insert { row ->
            row[id] = creator.id
            row[login] = creator.login
            row[nodeId] = creator.nodeId
            row[avatarUrl] = creator.avatarUrl
            row[gravatarId] = creator.gravatarId
            row[url] = creator.url
            row[htmlUrl] = creator.htmlUrl
            row[followersUrl] = creator.followersUrl
            row[followingUrl] = creator.followingUrl
            row[gistsUrl] = creator.gistsUrl
            row[starredUrl] = creator.starredUrl
            row[subscriptionsUrl] = creator.subscriptionsUrl
            row[organizationsUrl] = creator.organizationsUrl
            row[reposUrl] = creator.reposUrl
            row[eventsUrl] = creator.reposUrl
            row[receivedEventsUrl] = creator.receivedEventsUrl
            row[type] = creator.type
            row[siteAdmin] = creator.siteAdmin
        } get Creators.id
    }

    private fun insertSender(sender: Sender): Long {
        return Senders.insertIgnore { row ->
            row[id] = sender.id
            row[login] = sender.login
            row[nodeId] = sender.nodeId
            row[avatarUrl] = sender.avatarUrl
            row[gravatarId] = sender.gravatarId
            row[url] = sender.url
            row[htmlUrl] = sender.htmlUrl
            row[followersUrl] = sender.followersUrl
            row[followingUrl] = sender.followingUrl
            row[gistsUrl] = sender.gistsUrl
            row[starredUrl] = sender.starredUrl
            row[subscriptionsUrl] = sender.subscriptionsUrl
            row[organizationsUrl] = sender.organizationsUrl
            row[reposUrl] = sender.reposUrl
            row[eventsUrl] = sender.eventsUrl
            row[receivedEventsUrl] = sender.receivedEventsUrl
            row[type] = sender.type
            row[siteAdmin] = sender.siteAdmin
        } get Senders.id
    }

    private fun insertRepository(repository: Repository): Long {
        return Repositorys.insertIgnore { row ->
            row[id] = repository.id
            row[nodeId] = repository.nodeId
            row[name] = repository.name
            row[fullName] = repository.fullName
            row[_private] = repository._private
            row[ownerId] = repository.owner?.let { insertOwner(it) }
            row[htmlUrl] = repository.htmlUrl
            row[description] = repository.description
            row[fork] = repository.fork
            row[url] = repository.url
            row[forksUrl] = repository.forksUrl
            row[keysUrl] = repository.keysUrl
            row[collaboratorsUrl] = repository.collaboratorsUrl
            row[teamsUrl] = repository.teamsUrl
            row[hooksUrl] = repository.hooksUrl
            row[issueEventsUrl] = repository.issueEventsUrl
            row[eventsUrl] = repository.eventsUrl
            row[assigneesUrl] = repository.assigneesUrl
            row[branchesUrl] = repository.branchesUrl
            row[tagsUrl] = repository.tagsUrl
            row[blobsUrl] = repository.blobsUrl
            row[gitTagsUrl] = repository.gitTagsUrl
            row[gitRefsUrl] = repository.gitRefsUrl
            row[treesUrl] = repository.treesUrl
            row[statusesUrl] = repository.statusesUrl
            row[languagesUrl] = repository.languagesUrl
            row[stargazersUrl] = repository.stargazersUrl
            row[contributorsUrl] = repository.contributorsUrl
            row[subscribersUrl] = repository.subscribersUrl
            row[subscriptionUrl] = repository.subscriptionUrl
            row[commitsUrl] = repository.commentsUrl
            row[gitCommitsUrl] = repository.gitCommitsUrl
            row[commentsUrl] = repository.commentsUrl
            row[issueCommentUrl] = repository.issueCommentUrl
            row[contentsUrl] = repository.contentsUrl
            row[compareUrl] = repository.compareUrl
            row[mergesUrl] = repository.mergesUrl
            row[archiveUrl] = repository.archiveUrl
            row[downloadsUrl] = repository.downloadsUrl
            row[issuesUrl] = repository.issuesUrl
            row[pullsUrl] = repository.pullsUrl
            row[milestonesUrl] = repository.milestonesUrl
            row[notificationsUrl] = repository.notificationsUrl
            row[labelsUrl] = repository.labelsUrl
            row[releasesUrl] = repository.releasesUrl
            row[deploymentsUrl] = repository.deploymentsUrl
            row[createdAt] = repository.createdAt
            row[updatedAt] = repository.updatedAt
            row[pushedAt] = repository.pushedAt
            row[gitUrl] = repository.gitUrl
            row[sshUrl] = repository.sshUrl
            row[cloneUrl] = repository.cloneUrl
            row[svnUrl] = repository.svnUrl
            row[homepage] = repository.homepage
            row[size] = repository.size
            row[stargazersCount] = repository.stargazersCount
            row[watchersCount] = repository.watchersCount
            row[language] = repository.language
            row[hasIssues] = repository.hasIssues
            row[hasProjects] = repository.hasProjects
            row[hasDownloads] = repository.hasDownloads
            row[hasWiki] = repository.hasWiki
            row[hasPages] = repository.hasPages
            row[forksCount] = repository.forksCount
            row[mirrorUrl] = repository.mirrorUrl
            row[archived] = repository.archived
            row[disabled] = repository.disabled
            row[openIssuesCount] = repository.openIssuesCount
            row[licenseId] = repository.license?.let { insertLicense(it) } //repository.license
            row[forks] = repository.forks
            row[openIssues] = repository.openIssues
            row[watchers] = repository.watchers
            row[defaultBranch] = repository.defaultBranch
        } get Repositorys.id
    }

    private fun insertOwner(owner: Owner): Long {
        return Owners.insertIgnore { row ->
            row[id] = owner.id
            //row[name] = owner.name
            //row[email] = owner.email
            row[login] = owner.login
            row[nodeId] = owner.nodeId
            row[avatarUrl] = owner.avatarUrl
            row[gravatarId] = owner.gravatarId
            row[url] = owner.url
            row[htmlUrl] = owner.htmlUrl
            row[followersUrl] = owner.followersUrl
            row[followingUrl] = owner.followingUrl
            row[gistsUrl] = owner.gistsUrl
            row[starredUrl] = owner.starredUrl
            row[subscriptionsUrl] = owner.subscriptionsUrl
            row[organizationsUrl] = owner.organizationsUrl
            row[reposUrl] = owner.reposUrl
            row[eventsUrl] = owner.eventsUrl
            row[receivedEventsUrl] = owner.receivedEventsUrl
            row[type] = owner.type
            row[siteAdmin] = owner.siteAdmin
        } get Owners.id

    }

    private fun insertLabel(label: Label): Long {
        return Labels.insertIgnore { row ->
            row[id] = label.id
            row[nodeId] = label.nodeId
            row[url] = label.url
            row[name] = label.name
            row[color] = label.color
            row[_default] = label._default
        } get Labels.id
    }

    private fun insertLicense(license: License): String? {
        return Licenses.insertIgnore { row ->
            row[key] = license.key
            row[name] = license.name
            row[spdxId] = license.spdxId
            row[url] = license.url
            row[nodeId] = license.nodeId
        } get Licenses.nodeId
    }

    private fun insertLabels(issue: Issue) {
        issue.labels?.forEach { insertLabel(it) }
        insertIssuesLabels(issue)
    }

    private fun insertChange(change: Change): String? {
        return Changes.insertIgnore { row ->
            row[bodyId] = insertBody(change.body).toString()  //change.body.from
        } get Changes.bodyId
    }

    private fun insertBody(body: Body): String? {
        return Bodys.insertIgnore { row ->
            row[from] = body.from
        } get Bodys.from
    }

    private fun insertsAssignees(issue: Issue) {
        issue.assignees?.forEach { insertAssignee(it) }
        insertIssuesAssignees(issue)
    }

    private fun insertIssuesAssignees(issue: Issue) {
        IssuesAssignees.batchInsert(issue.assignees!!.asIterable()) { assignee ->
            this[IssuesAssignees.issueId] = issue.id
            this[IssuesAssignees.assigneeld] = assignee.id
        }
    }

    private fun insertIssuesLabels(issue: Issue) {
        IssuesLabels.batchInsert(issue.labels!!.asIterable()) { label ->
            this[IssuesLabels.issueId] = issue.id
            this[IssuesLabels.labeld] = label.id
        }
    }
}

