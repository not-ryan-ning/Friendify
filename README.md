# Friendify
## Problem Domain Description
The problem domain of Friendify is social connections and friend-matching.

## Software Specification
Friendify allows users to find and match with other users in the system based on the similarities of their Spotify playlists. The user first signs up for their account, and they create their profile which also includes their choice of Spotify playlist for matching. Afterwards, they can use the match functionality to view other users who have similar Spotify playlist features and choose to send friend requests to them. Once those requests are accepted, it displays their Spotify handles.

## Proposed Entities for Domain
- User (includes username, password, bio, friends, playlist)
- Playlist (includes songs, artists, top three highlights)
- Friend (Spotify handle)

## Use Cases
- Login, SignUp, LogOut, EditProfile, DisplayProfile, DisplayFriends, Match, SendRequests, AcceptRequests

## Developer Workflow
Task (describe plan) -> Pull Request (Technical plan, concerns, limitations) -> Code (working commits/push) -> Midway Review -> Continue Coding －> Final Code Review (PR) -> Accept/Reject